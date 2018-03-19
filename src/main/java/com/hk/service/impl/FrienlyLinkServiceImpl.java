package com.hk.service.impl;

import com.hk.dao.FriendlyLinkDao;
import com.hk.entity.FriendlyLink;
import com.hk.service.FriendlyLinkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: WillWang
 * @Description:
 * @Date: Created in 2018/3/19 16:38
 */
@Service("friendlyLinkService")
public class FrienlyLinkServiceImpl implements FriendlyLinkService{

    @Resource
    private FriendlyLinkDao friendlyLinkDao;

    public List<FriendlyLink> getLinks(Map<String, Object> map) {
        return friendlyLinkDao.getLinkList(map);
    }

    public Long getTotalLink(Map<String, Object> map) {
        return friendlyLinkDao.getTotalLinks(map);
    }
}
