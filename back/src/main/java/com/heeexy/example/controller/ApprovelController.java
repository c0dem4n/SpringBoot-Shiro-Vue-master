package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.entity.PublicInfo;
import com.heeexy.example.service.ApprovelService;
import com.heeexy.example.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wzq
 */
@RestController
@RequestMapping("/approvel")
public class ApprovelController {
    @Autowired
    private ApprovelService approvelService;

    @RequiresPermissions("user:list")
    @RequestMapping("listApprovel")
    public JSONObject listApprovel(HttpServletRequest request){
        return approvelService.listApprovel(CommonUtil.request2Json(request));
    }

    @RequiresPermissions("role:reply")
    @RequestMapping("/addReply")
    public JSONObject addReply(JSONObject jsonObject){
        return approvelService.addReply(jsonObject);
    }
    @RequiresPermissions("user:add")
    @RequestMapping("/addApprovel")
    public JSONObject addApprovel(JSONObject jsonObject){
        return approvelService.addApprovel(jsonObject);
    }

}
