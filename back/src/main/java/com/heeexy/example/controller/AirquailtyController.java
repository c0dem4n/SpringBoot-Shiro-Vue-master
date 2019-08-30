package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.AirquailtyService;
import com.heeexy.example.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wzq
 */
@RestController
@RequestMapping("/air")
public class AirquailtyController {

    @Autowired
    AirquailtyService airquailtyService;

    @RequiresPermissions("user:list")
    @GetMapping("/listair")
    public JSONObject listair(HttpServletRequest request){
        return airquailtyService.listair(CommonUtil.request2Json(request));
    }
}
