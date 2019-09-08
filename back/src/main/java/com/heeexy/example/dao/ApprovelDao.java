package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by wzq
 */
@MapperScan
public interface ApprovelDao {
    void addApprovel(JSONObject jsonObject);
    void replyApprovel(JSONObject jsonObject);
    void updateApprovel(JSONObject jsonObject);
    List<JSONObject> listApprovel(JSONObject jsonObject);
    int countApprovel(JSONObject jsonObject);
}
