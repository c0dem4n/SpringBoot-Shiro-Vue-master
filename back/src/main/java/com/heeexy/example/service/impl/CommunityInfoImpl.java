package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.CommunityInfoDao;
import com.heeexy.example.service.CommunityInfoService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wzq
 */
@Service
public class CommunityInfoImpl implements CommunityInfoService {
    @Autowired
    private CommunityInfoDao communityInfoDao;

    public JSONObject listInfo(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = communityInfoDao.countCommunity(jsonObject);
        List<JSONObject> list = communityInfoDao.getCommunityInfo(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }
}
