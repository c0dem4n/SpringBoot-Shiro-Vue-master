package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by wzq
 */
public interface PublicInfoService {
    JSONObject listPublicInfo(JSONObject jsonObject);
    JSONObject addPublicInfo(JSONObject jsonObject);
    JSONObject updatePublicInfo(JSONObject jsonObject);
    JSONObject deleteInfo(JSONObject jsonObject);
}
