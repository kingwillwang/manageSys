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

    /**
     * 增加
     * @param friendlyLink
     * @return
     */
    public int addLink(FriendlyLink friendlyLink);

    /**
     * 修改
     * @param friendlyLink
     * @return
     */
    public int updateLink(FriendlyLink friendlyLink);

    /**
     * 删除
     * @param ids
     */
    public void deleteLinksById(String[] ids);
}
