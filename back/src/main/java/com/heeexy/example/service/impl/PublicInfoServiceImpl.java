package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.PublicInfoDao;
import com.heeexy.example.service.PublicInfoService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wzq
 */
@Service
public class PublicInfoServiceImpl implements PublicInfoService {
    @Autowired
    private PublicInfoDao publicInfoDao;

    public JSONObject addPublicInfo(JSONObject jsonObject){
        publicInfoDao.addInfo(jsonObject);
        return CommonUtil.successJson();
    }

    public JSONObject listPublicInfo(JSONObject jsonObject){
        CommonUtil.fillPageParam(jsonObject);
        int count = publicInfoDao.countPulicInfo(jsonObject);
        List<JSONObject> list = publicInfoDao.listPublicInfo(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }
    public JSONObject updatePublicInfo(JSONObject jsonObject) {
        publicInfoDao.updatePublicInfo(jsonObject);
        return CommonUtil.successJson();
    }
    public JSONObject deleteInfo(JSONObject jsonObject){
        publicInfoDao.deleteInfo(jsonObject);
        return CommonUtil.successJson();
    }
}
