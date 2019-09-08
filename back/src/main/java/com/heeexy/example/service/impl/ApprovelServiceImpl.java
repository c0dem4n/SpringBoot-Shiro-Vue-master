package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.ApprovelDao;
import com.heeexy.example.service.ApprovelService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wzq
 */
@Service
public class ApprovelServiceImpl implements ApprovelService {
    @Autowired
    private ApprovelDao approvelDao;
    public JSONObject addApprovel(JSONObject jsonObject){
        approvelDao.addApprovel(jsonObject);
        return CommonUtil.successJson();
    }
    public JSONObject addReply(JSONObject jsonObject){
        approvelDao.replyApprovel(jsonObject);
        approvelDao.updateApprovel(jsonObject);
        return CommonUtil.successJson();
    }
    public JSONObject listApprovel(JSONObject jsonObject){
        CommonUtil.fillPageParam(jsonObject);
        int count=approvelDao.countApprovel(jsonObject);
        List<JSONObject> list=approvelDao.listApprovel(jsonObject);
        return CommonUtil.successPage(jsonObject,list,count);
    }
}
