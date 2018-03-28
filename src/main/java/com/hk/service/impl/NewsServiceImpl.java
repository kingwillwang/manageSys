package com.hk.service.impl;

import com.hk.dao.NewsDao;
import com.hk.entity.News;
import com.hk.service.NewsService;
import com.hk.util.AntiXssUtil;
import com.hk.util.DateUtil;
import com.hk.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/27 13:21
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {

    @Resource
    private NewsDao newsDao;

    public List<News> getNewsList(Map<String, Object> map) {
        return newsDao.getNewsList(map);
    }

    public Long getTotalNews(Map<String, Object> map) {
        return newsDao.getTotalNews(map);
    }

    public int addNews(News news) {
        if (StringUtil.isEmpty(news.getNewsTitle())){
            return 0;//标题不能为空
        }
        news.setId(UUID.randomUUID().toString());
        news.setNewsTitle(AntiXssUtil.replaceHtmlCode(news.getNewsTitle()));
        news.setSummary(AntiXssUtil.replaceHtmlCode(news.getSummary()));
        news.setCountNum(0);
        news.setCreateDate(DateUtil.getCurrentDateStr());
        news.setContent(AntiXssUtil.replaceHtmlCode(news.getContent()));
        newsDao.addNews(news);
        return 1;//创建成功
    }

    public int updateNews(News news) {
        if (StringUtil.isEmpty(news.getNewsTitle())){
            return 0;//标题不能为空
        }
        news.setNewsTitle(AntiXssUtil.replaceHtmlCode(news.getNewsTitle()));
        news.setSummary(AntiXssUtil.replaceHtmlCode(news.getSummary()));
        news.setContent(AntiXssUtil.replaceHtmlCode(news.getContent()));
        newsDao.updateNews(news);
        return 1;//创建成功
    }

    public void deleteNews(String[] ids) {
        newsDao.deleteNews(ids);
    }

    public News findById(String id) {
        return newsDao.findNewsById(id);
    }

}
