package com.hk.controller;

import com.hk.common.Result;
import com.hk.common.ResultGenerator;
import com.hk.entity.News;
import com.hk.entity.PageBean;
import com.hk.service.NewsService;
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
 * @Date: Created in 2018/3/27 13:51
 */
@Controller
@RequestMapping("/news")
public class NewsController {

    @Resource
    private NewsService newsService;
    private static final Logger log = Logger.getLogger(NewsController.class);// 日志文件

    @RequestMapping(value = "/newsList", method = RequestMethod.POST)
    @ResponseBody
    public String list(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows", required = false) String rows,
                       News news, HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("newsTitle", StringUtil.formatLike(news.getNewsTitle()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<News> newsList = newsService.getNewsList(map);
        Long total = newsService.getTotalNews(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(newsList);
        result.put("rows", jsonArray);
        result.put("total", total);
        log.info("request: news/newsList , map: " + map.toString());
        ResponseUtil.write(response, result);
        return null;
    }


    @RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Result addOrUpdate(@RequestBody News news) {
        int resultCode = -1;
        if (StringUtil.isEmpty(news.getId())) {
            //新增
            resultCode = newsService.addNews(news);
        } else {
            //修改
            resultCode = newsService.updateNews(news);
        }
        if (resultCode == 1) {
            return ResultGenerator.genSuccessResult();
        } else if (resultCode == 0){
            return ResultGenerator.genBadResult("标题不能为空！");
        } else {
            return ResultGenerator.genFailResult("操作失败！");
        }
    }

    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable(value = "ids") String ids){
        String[] idsStr = ids.split(",");
        newsService.deleteNews(idsStr);
        log.info("request: news/delete , ids: " + ids);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 根据id查找
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result findById(@PathVariable("id") String id){
        News news = newsService.findById(id);
        Result result = ResultGenerator.genSuccessResult();
        result.setData(news);
        log.info("request: news/findById");
        return result;
    }
}
