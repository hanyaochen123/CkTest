package com.kuang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kuang.common.ApiClassificationOV;
import com.kuang.pojo.ApiClassification;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiClassificationmapper extends BaseMapper<ApiClassification> {

    @Select("select * from api_classification where project_id=#{projectId}")
    @Results({
            @Result(column = "id",property = "apis",
                    many = @Many(select="com.kuang.mapper.Apimapper.findApi"))
    })
    List<ApiClassificationOV> getWithList(Integer projectId);



}
