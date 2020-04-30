package com.kuang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kuang.common.ApiClassificationOV;
import com.kuang.pojo.ApiClassification;

import java.util.List;

public interface ApiClassificationService extends IService<ApiClassification>{
    public List<ApiClassificationOV> getWithList(Integer projectId);


}
