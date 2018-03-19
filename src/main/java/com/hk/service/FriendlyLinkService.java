package com.hk.service;

import com.hk.entity.FriendlyLink;

import java.util.List;
import java.util.Map;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/19 16:37
 */
public interface FriendlyLinkService {

    /**
     * @author willwang
     * @date 2018/3/19 16:37
     * @param
     * @return
     */
    public List<FriendlyLink> getLinks(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    public Long getTotalLink(Map<String, Object> map);
}
