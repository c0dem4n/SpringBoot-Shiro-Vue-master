package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by wzq
 */
@MapperScan
public interface PublicInfoDao {
    /**
     * 公共信息
     */
    void addInfo(JSONObject jsonObject);
    int countPulicInfo(JSONObject jsonObject);
    List<JSONObject> listPublicInfo(JSONObject jsonObject);
    int updatePublicInfo(JSONObject jsonObject);
    void deleteInfo(JSONObject jsonObject);
}
