package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.PublicInfoDao;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wzq
 */
@Service
public class PublicInfoImpl {
    @Autowired
    private PublicInfoDao publicInfoDao;

    public JSONObject addInfo(JSONObject jsonObject){
        publicInfoDao.addInfo(jsonObject);
        return CommonUtil.successJson();
    }
}
