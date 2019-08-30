package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.entity.CommunityInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by wzq
 */
@Mapper
public interface CommunityInfoDao {
    List<JSONObject> getCommunityInfo(JSONObject jsonObject);
    int countCommunity(JSONObject jsonObject);
    
}
