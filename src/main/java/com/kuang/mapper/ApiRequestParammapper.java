package com.kuang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.kuang.pojo.ApiRequestParam;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ApiRequestParammapper extends BaseMapper<ApiRequestParam> {
    @Select("select * from api_request_param where api_id=#{apiId}")
    List<ApiRequestParam> findAll(Integer apiId);

}
