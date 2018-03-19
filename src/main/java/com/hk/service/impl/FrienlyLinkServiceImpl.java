package com.hk.service.impl;

import com.hk.dao.FriendlyLinkDao;
import com.hk.entity.FriendlyLink;
import com.hk.service.FriendlyLinkService;
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
 * @Date: Created in 2018/3/19 16:38
 */
@Service("friendlyLinkService")
public class FrienlyLinkServiceImpl implements FriendlyLinkService {

    @Resource
    private FriendlyLinkDao friendlyLinkDao;

    public List<FriendlyLink> getLinks(Map<String, Object> map) {
        return friendlyLinkDao.getLinkList(map);
    }

    public Long getTotalLink(Map<String, Object> map) {
        return friendlyLinkDao.getTotalLinks(map);
    }

    public int addLink(FriendlyLink friendlyLink) {
        if (StringUtil.isEmpty(friendlyLink.getLinkName()) || StringUtil.isEmpty(friendlyLink.getLinkUrl())) {
            return 0;//名称或地址不能为空
        }
        Long isExist = friendlyLinkDao.findLinkNameIsExist(friendlyLink.getLinkName());
        if (isExist > 0) {
            return 2;//已存在
        } else {
            friendlyLink.setId(UUID.randomUUID().toString());
            friendlyLink.setCreateDate(DateUtil.getCurrentDateStr());
            friendlyLink.setModifyDate(DateUtil.getCurrentDateStr());
            friendlyLink.setLinkName(AntiXssUtil.replaceHtmlCode(friendlyLink.getLinkName()));
            friendlyLinkDao.addLinks(friendlyLink);
            return 1;//创建成功
        }
    }

    public int updateLink(FriendlyLink friendlyLink) {
        if (StringUtil.isEmpty(friendlyLink.getLinkName()) || StringUtil.isEmpty(friendlyLink.getLinkUrl())) {
            return 0;//名称或地址不能为空
        }
        FriendlyLink newFriendlyLink = friendlyLinkDao.findLinkById(friendlyLink.getId());
        newFriendlyLink.setModifyDate(DateUtil.getCurrentDateStr());
        newFriendlyLink.setLinkName(AntiXssUtil.replaceHtmlCode(friendlyLink.getLinkName()));
        newFriendlyLink.setLinkUrl(friendlyLink.getLinkUrl());
        friendlyLinkDao.updateLink(newFriendlyLink);
        return 1;//操作成功
    }

    public void deleteLinksById(String[] ids) {
        friendlyLinkDao.deleteLinks(ids);
    }
}
