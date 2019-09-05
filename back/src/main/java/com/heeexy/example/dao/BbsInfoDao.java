package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by wzq
 */
@MapperScan
public interface BbsInfoDao {
    List<JSONObject> listbbs(JSONObject jsonObject);
    int countbbs(JSONObject jsonObject);
    int addInfo(JSONObject jsonObject);
    int replyInfo(JSONObject jsonObject);
    List<JSONObject> bbsInfo(JSONObject jsonObject);
    int countreply(JSONObject jsonObject);
}
