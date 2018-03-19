package com.hk.controller;

import com.hk.common.Result;
import com.hk.common.ResultGenerator;
import com.hk.entity.FriendlyLink;
import com.hk.entity.PageBean;
import com.hk.service.FriendlyLinkService;
import com.hk.util.AntiXssUtil;
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
 * @Date: Created in 2018/3/19 16:41
 */
@Controller
@RequestMapping("/friendlyLink")
public class FriendlyLinkController {

    @Resource
    private FriendlyLinkService friendlyLinkService;

    private static final Logger log = Logger.getLogger(FriendlyLinkController.class);// 日志文件


    @RequestMapping(value = "/linkList", method = RequestMethod.POST)
    @ResponseBody
    public String list(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows", required = false) String rows,
                       FriendlyLink friendlyLink, HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("linkName", StringUtil.formatLike(friendlyLink.getLinkName()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<FriendlyLink> linkList = friendlyLinkService.getLinks(map);
        Long total = friendlyLinkService.getTotalLink(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(linkList);
        result.put("rows", jsonArray);
        result.put("total", total);
        log.info("request: friendlyLink/linkList , map: " + map.toString());
        ResponseUtil.write(response, result);
        return null;
    }

    @RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Result addOrUpdate(@RequestBody FriendlyLink friendlyLink) {
        int resultCode = -1;
        brandType.setTypeName(AntiXssUtil.replaceHtmlCode(typeName));
        if (StringUtil.isEmpty(brandType.getId())) {
            //新增
            resultCode = brandTypeService.addBrandType(brandType);
        } else {
            //修改
            resultCode = brandTypeService.updateBrandType(brandType);
        }
        if (resultCode == 1) {
            return ResultGenerator.genSuccessResult();
        } else if (resultCode == 2) {
            return ResultGenerator.genBadResult("该类型已存在！");
        } else if (resultCode == 0){
            return ResultGenerator.genBadResult("名称不能为空！");
        } else {
            return ResultGenerator.genFailResult("操作失败！");
        }
    }
}
