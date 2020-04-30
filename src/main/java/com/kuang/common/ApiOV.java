package com.kuang.common;

import com.kuang.pojo.Api;
import com.kuang.pojo.ApiRequestParam;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ApiOV extends Api {
    private String caeateUsername;
    private String host;
    private List<ApiRequestParam> requestParams=new ArrayList<>();


}
