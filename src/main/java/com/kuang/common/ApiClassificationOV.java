package com.kuang.common;

import com.kuang.pojo.Api;
import com.kuang.pojo.ApiClassification;
import lombok.Data;

import java.util.List;

@Data
public class ApiClassificationOV extends ApiClassification {
    List<Api> apis;

}
