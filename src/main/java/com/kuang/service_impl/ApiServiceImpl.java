package com.kuang.service_impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kuang.common.ApiListOV;
import com.kuang.common.ApiOV;
import com.kuang.mapper.Apimapper;
import com.kuang.pojo.Api;
import com.kuang.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiServiceImpl extends ServiceImpl<Apimapper, Api> implements ApiService {
    @Autowired
    Apimapper apimapper;

    @Override
    public List<ApiListOV> getListByproject(Integer project) {
        List<ApiListOV> listByproject = apimapper.getListByproject(project);
        return listByproject;
    }

    @Override
    public List<ApiListOV> getListByClassification(Integer id) {
        List<ApiListOV> listByClassification = apimapper.getListByClassification(id);

        return listByClassification;
    }

    @Override
    public List<ApiOV> joinUsername(Integer apiId) {
        List<ApiOV> apiOVS = apimapper.joinUsername(apiId);
        return apiOVS;
    }
}
