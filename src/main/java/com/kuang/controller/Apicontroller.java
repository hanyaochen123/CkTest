package com.kuang.controller;

import com.kuang.common.ApiListOV;
import com.kuang.common.ApiOV;
import com.kuang.common.Result;
import com.kuang.pojo.User;
import com.kuang.service.ApiService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Apicontroller {
    @Autowired
    ApiService apiService;

    /**
     * @param projectId
     * @return
     *根据projectId查询接口分类
     */
    @GetMapping("/showListApi")
    public Result showListProject(Integer projectId){
        Result result=null;
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        user.getId();
        System.out.println(user.getId()); 
        List<ApiListOV> listByproject = apiService.getListByproject(projectId);
        result = new Result("1",listByproject,"查询成功");
        return result;
    }

    /**
     * @param id
     * @return
     * 根据分类查分类下的接口数据
     */
    @GetMapping("/showListClass")
    public Result showListClassification(Integer id){
        Result result=null;
        List<ApiListOV> listByClassification = apiService.getListByClassification(id);
        result =new Result("1",listByClassification,"查询成功");
        return result;
    }
    /*
    在接口详情显示登陆的用户
     */
    @GetMapping("toApiview")
    public Result joinUsername(Integer userId){
        Result result=null;
        List<ApiOV> apiOVS = apiService.joinUsername(userId);
        result = new Result("1",apiOVS,"Apiview查询成功");
        return result;


    }

}
