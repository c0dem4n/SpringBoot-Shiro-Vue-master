package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.BbsInfoService;
import com.heeexy.example.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wzq
 */
@RestController
@RequestMapping("/bbs")
public class bbsInfoController {
    @Autowired
    private BbsInfoService bbsInfoService;

    @RequiresPermissions("user:list")
    @RequestMapping("/bbsInfo")
    public JSONObject listbbs(HttpServletRequest request){
        return bbsInfoService.listbbs(CommonUtil.request2Json(request));
    }
    @RequiresPermissions("user:add")
    @PostMapping("/createInfo")
    public JSONObject addInfo(JSONObject jsonObject){
        return bbsInfoService.addInfo(jsonObject);
    }
    @RequiresPermissions("user:add")
    @PostMapping("/replyInfo")
    public JSONObject replyInfo(JSONObject jsonObject){
        return bbsInfoService.replyInfo(jsonObject);
    }
}
