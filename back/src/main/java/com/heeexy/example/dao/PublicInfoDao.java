package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created by wzq
 */
@MapperScan
public interface PublicInfoDao {
    /**
     * 公共信息
     */
    void addInfo(JSONObject jsonObject);
}
