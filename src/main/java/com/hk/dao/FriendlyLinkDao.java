package com.hk.dao;

import com.hk.entity.FriendlyLink;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/19 16:22
 */
@Repository
public interface FriendlyLinkDao {

    /**
     * 增加
     * @author willwang
     * @date 2018/3/19 16:23
     * @param
     * @return
     */
    public void addLinks(FriendlyLink friendlyLink);

    /**
     * 查询
     * @author willwang
     * @date 2018/3/19 16:24
     * @param
     * @return
     */
    public List<FriendlyLink> getLinkList(Map<String, Object> map);

    public Long getTotalLinks(Map<String, Object> map);

    /**
     * 修改
     * @author willwang
     * @date 2018/3/19 16:25
     * @param
     * @return
     */
    public void updateLink(FriendlyLink friendlyLink);

    /**
     * 删除
     * @author willwang
     * @date 2018/3/19 16:26
     * @param
     * @return
     */
    public void deleteLinks(String[] ids);
}
