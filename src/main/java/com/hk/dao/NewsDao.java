package com.hk.dao;

import com.hk.entity.News;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/27 13:10
 */
@Repository
public interface NewsDao {

    public List<News> getNewsList(Map<String, Object> map);

    public Long getTotalNews(Map<String, Object> map);

    public void addNews(News news);

    public void updateNews(News news);

    public void deleteNews(String[] ids);

    public News findNewsById(String id);
}
