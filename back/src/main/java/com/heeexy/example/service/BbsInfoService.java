package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by wzq
 */
public interface BbsInfoService {
    JSONObject listbbs(JSONObject jsonObject);
    JSONObject addInfo(JSONObject jsonObject);
    JSONObject replyInfo(JSONObject jsonObject);
}
