package com.kuang.service_impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kuang.common.ApiClassificationOV;
import com.kuang.mapper.ApiClassificationmapper;
import com.kuang.pojo.ApiClassification;
import com.kuang.service.ApiClassificationService;
import com.kuang.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiServiceClassificationImpl  extends ServiceImpl<ApiClassificationmapper,ApiClassification> implements ApiClassificationService{
    @Autowired
    ApiClassificationmapper apiClassificationmapper;

    @Override
    public List<ApiClassificationOV> getWithList(Integer projectId) {

        return apiClassificationmapper.getWithList(projectId);
    }
}
