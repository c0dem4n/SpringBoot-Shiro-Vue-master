package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.AirquailtyDao;
import com.heeexy.example.service.AirquailtyService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created by wzq
 */
@Service
public class AirquailtyServiceImpl implements AirquailtyService {
    @Autowired
    private AirquailtyDao airquailtyDao;

    public JSONObject listair(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = airquailtyDao.listair(jsonObject);
        return CommonUtil.successPage(list);
    }
}
