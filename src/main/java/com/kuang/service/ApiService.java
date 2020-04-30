package com.kuang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kuang.common.ApiListOV;
import com.kuang.common.ApiOV;
import com.kuang.mapper.Apimapper;
import com.kuang.pojo.Api;

import java.util.List;

public interface ApiService extends IService<Api> {
    /*
    根据ProjectId去查对应的接口类
     */
    List<ApiListOV> getListByproject(Integer project);
    /*
    根据接口类去查下面具体接口
     */
    List<ApiListOV> getListByClassification(Integer id);
    /*
    根据Username把用户名显示到接口详情
     */
    List<ApiOV> joinUsername(Integer apiId);
}
