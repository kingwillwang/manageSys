package com.hk.service;

import com.hk.entity.News;

import java.util.List;
import java.util.Map;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/27 13:19
 */
public interface NewsService {

    public List<News> getNewsList(Map<String, Object> map);

    public Long getTotalNews(Map<String, Object> map);

    public int addNews(News news);

    public int updateNews(News news);

    public void deleteNews(String[] ids);

}
