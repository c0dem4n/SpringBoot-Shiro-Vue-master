package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by wzq
 */
@MapperScan
public interface AirquailtyDao {
    List<JSONObject> listair(JSONObject jsonObject);
}
