package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.BbsInfoDao;
import com.heeexy.example.service.BbsInfoService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wzq
 */
@Service
public class BbsInfoServiceImpl implements BbsInfoService {
    @Autowired
    private BbsInfoDao bbsInfoDao;

    public JSONObject listbbs(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = bbsInfoDao.countbbs(jsonObject);
        List<JSONObject> list = bbsInfoDao.listbbs(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    public JSONObject addInfo(JSONObject jsonObject) {
        bbsInfoDao.addInfo(jsonObject);
        return CommonUtil.successJson();
    }
    /*
    * 回帖
    *
    * */
    public JSONObject replyInfo(JSONObject jsonObject){
        bbsInfoDao.replyInfo(jsonObject);
        return CommonUtil.successJson();
    }
    /*
    * 查看详情
    * */
    public JSONObject bbsInfo(JSONObject jsonObject){
        CommonUtil.fillPageParam(jsonObject);
        int count = bbsInfoDao.countreply(jsonObject);
        List<JSONObject> list = bbsInfoDao.bbsInfo(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }
}
