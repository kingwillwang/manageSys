package com.hk.controller;

import com.hk.common.Result;
import com.hk.common.ResultGenerator;
import com.hk.entity.PageBean;
import com.hk.entity.SysUser;
import com.hk.service.SysUserService;
import com.hk.util.MD5Util;
import com.hk.util.ResponseUtil;
import com.hk.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/12 11:11
 */
@Controller
@RequestMapping("/users")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    private static final Logger log = Logger.getLogger(SysUserController.class);// 日志文件

    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/cookie", method = RequestMethod.POST)
    @ResponseBody
    public Result login(SysUser user) {
        try {
            String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
            user.setPassword(MD5pwd);
        } catch (Exception e) {
            user.setPassword("");
        }
        SysUser resultUser = sysUserService.login(user);
        log.info("request: user/login , user: " + user.toString());
        if (resultUser == null) {
            return ResultGenerator.genFailResult("请认真核对账号、密码！");
        } else {
            resultUser.setPassword("PASSWORD");
            Map map = new HashMap();
            map.put("currentUser", resultUser);
            return ResultGenerator.genSuccessResult(map);
        }
    }

    /**
     * 用户列表
     * @param sysUser
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/datagrid", method = RequestMethod.POST)
    @ResponseBody
    public String list(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows", required = false) String rows, SysUser sysUser, HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", StringUtil.formatLike(sysUser.getUserName()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<SysUser> userList = sysUserService.findUser(map);
        Long total = sysUserService.getTotalUser(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(userList);
        result.put("rows", jsonArray);
        result.put("total", total);
        log.info("request: user/list , map: " + map.toString());
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 添加管理员
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody SysUser user) throws Exception {
        int resultTotal = 0;
        String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
        user.setPassword(MD5pwd);
        resultTotal = sysUserService.addUser(user);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }
}
