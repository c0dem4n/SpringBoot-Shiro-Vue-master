package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by wzq
 */
public interface AirquailtyService {
    /*
    * 查询空气状况
    * */
    JSONObject listair(JSONObject jsonObject);
}
