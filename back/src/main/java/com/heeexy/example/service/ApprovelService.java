package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by wzq
 */
public interface ApprovelService {
    JSONObject listApprovel(JSONObject jsonObject);
    JSONObject addApprovel(JSONObject jsonObject);
    JSONObject addReply(JSONObject jsonObject);
}
