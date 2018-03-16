package com.hk.controller;

import com.hk.common.Result;
import com.hk.common.ResultGenerator;
import com.hk.entity.BrandType;
import com.hk.entity.PageBean;
import com.hk.entity.SysUser;
import com.hk.entity.UserProperty;
import com.hk.service.BrandTypeService;
import com.hk.service.SysUserService;
import com.hk.util.MD5Util;
import com.hk.util.ResponseUtil;
import com.hk.util.StringUtil;
import com.hk.util.UserUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/16
 */
@Controller
@RequestMapping("/brandType")
public class BrandTypeController {

    @Resource
    private BrandTypeService brandTypeService;

    private static final Logger log = Logger.getLogger(BrandTypeController.class);// 日志文件


    @RequestMapping(value = "/firstTypeList", method = RequestMethod.POST)
    @ResponseBody
    public String list(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows", required = false) String rows,
                       BrandType brandType, HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("typeName", StringUtil.formatLike(brandType.getTypeName()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<BrandType> brandTypeList = brandTypeService.findFirstBrandTypes(map);
        Long total = brandTypeService.getTotalFirstBrandType(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(brandTypeList);
        result.put("rows", jsonArray);
        result.put("total", total);
        log.info("request: brandType/firstTypeList , map: " + map.toString());
        ResponseUtil.write(response, result);
        return null;
    }

}
