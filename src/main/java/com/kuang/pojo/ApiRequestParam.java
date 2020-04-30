package com.kuang.pojo;

import lombok.Data;

@Data
public class ApiRequestParam {
    private int id;
    private Integer apiId;
    private String name;
    private String paramType;
    private Integer type;
    private String exampleData;
    private String description;
}
