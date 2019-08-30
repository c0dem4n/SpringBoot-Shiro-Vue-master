package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.CommunityInfoService;
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
@RequestMapping("/community")
public class CommunityInfoController {
    @Autowired
    private CommunityInfoService communityInfoService;
    /**
     * 查询小区信息
     */
    @RequiresPermissions("user:list")
    @GetMapping("/listInfo")
    public JSONObject listArticle(HttpServletRequest request) {
        return communityInfoService.listInfo(CommonUtil.request2Json(request));
    }
}
