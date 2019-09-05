package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.PublicInfoService;
import com.heeexy.example.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wzq
 */
@RestController
@RequestMapping("/publicInfo")
public class PublicInfoController {
    @Autowired
    private PublicInfoService publicInfoService;

    /*
    * 查询公共信息列表
    * */
    @RequiresPermissions("user:list")
    @GetMapping("/getListInfo")
    public JSONObject getListInfo(HttpServletRequest request){
        return publicInfoService.listPublicInfo(CommonUtil.request2Json(request));
    }
    /*
    * 插入公共信息
    * */
    @RequiresPermissions("role:add")
    @PostMapping("/addInfo")
    public JSONObject addInfo(@RequestBody JSONObject jsonObject){

        return publicInfoService.addPublicInfo(jsonObject);
    }
    @RequiresPermissions("role:update")
    @PostMapping("/updatePublicInfo")
    public JSONObject updatePublicInfo(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id,title,content");
        return publicInfoService.updatePublicInfo(requestJson);
    }
    @RequiresPermissions("role:update")
    @PostMapping("/deleteInfo")
    public JSONObject deleteInfo(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson,"id");
        return publicInfoService.deleteInfo(requestJson);
    }

}
