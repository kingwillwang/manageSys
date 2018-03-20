package com.hk.controller;

import com.hk.common.Result;
import com.hk.common.ResultGenerator;
import com.hk.entity.PageBean;
import com.hk.entity.Website;
import com.hk.service.WebsiteService;
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
 * @Date: Created in 2018/3/20 9:34
 */
@Controller
@RequestMapping("/website")
public class WebsiteController {

    @Resource
    private WebsiteService websiteService;

    private static final Logger log = Logger.getLogger(WebsiteController.class);// 日志文件

    /**
     * 十大品牌
     * @author willwang
     * @date 2018/3/20 9:38
     * @param
     * @return
     */
    @RequestMapping(value = "/topTenList", method = RequestMethod.POST)
    @ResponseBody
    public String topTenList(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows", required = false) String rows, HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Website> topTenList = websiteService.getTopTenWebsite(map);
        Long total = websiteService.getTotalTopTen(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(topTenList);
        result.put("rows", jsonArray);
        result.put("total", total);
        log.info("request: website/topTenList , map: " + map.toString());
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 不是十大品牌
     * @author willwang
     * @date 2018/3/20 11:18
     * @param
     * @return
     */
    @RequestMapping(value = "/notTopTenList", method = RequestMethod.POST)
    @ResponseBody
    public String notTopTenList(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows", required = false) String rows,
                                 Website website, HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("websiteName", StringUtil.formatLike(website.getWebsiteName()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Website> notTopTenList = websiteService.getNotTopTenWebsite(map);
        Long total = websiteService.getTotalNotTopTen(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(notTopTenList);
        result.put("rows", jsonArray);
        result.put("total", total);
        log.info("request: website/notTopTenList , map: " + map.toString());
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 添加十大
     * @author willwang
     * @date 2018/3/20 13:49
     * @param
     * @return
     */
    @RequestMapping(value = "/addTopTen/{ids}", method = RequestMethod.POST)
    @ResponseBody
    public Result addTopTen(@PathVariable(value = "ids") String ids){
        String[] idsStr = ids.split(",");
        websiteService.addTopTen(idsStr);
        log.info("request: website/addTopTen , ids: " + ids);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 移除十大
     * @author willwang
     * @date 2018/3/20 14:14
     * @param
     * @return
     */
    @RequestMapping(value = "/removeTopTen/{ids}", method = RequestMethod.POST)
    @ResponseBody
    public Result removeTopTen(@PathVariable(value = "ids") String ids){
        String[] idsStr = ids.split(",");
        websiteService.removeTopTen(idsStr);
        log.info("request: website/removeTopTen , ids: " + ids);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 所有品牌
     * @author willwang
     * @date 2018/3/20 10:12
     * @param
     * @return
     */
    @RequestMapping(value = "/allWebsiteList", method = RequestMethod.POST)
    @ResponseBody
    public String allWebsiteList(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows", required = false) String rows,
                                 Website website, HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("websiteName", StringUtil.formatLike(website.getWebsiteName()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Website> allWebsiteList = websiteService.getAllWebsite(map);
        Long total = websiteService.getTotalWebsite(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(allWebsiteList);
        result.put("rows", jsonArray);
        result.put("total", total);
        log.info("request: website/allWebsiteList , map: " + map.toString());
        ResponseUtil.write(response, result);
        return null;
    }

}
