package com.kuang.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kuang.common.ApiListOV;
import com.kuang.common.ApiOV;
import com.kuang.pojo.Api;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Apimapper extends BaseMapper<Api> {
    @Select("select * from api where api_classification_id =#{apiClassificationId}")
    List<Api> findApi(Integer apiClassificationId);

    @Select("select t1.*,t2.`name` classificationName from api t1,api_classification t2 where t2.project_id=#{project} and api_classification_id=t2.id")
    List<ApiListOV> getListByproject(Integer project);

    @Select("select t1.*,t2.`name` classificationName from api t1,api_classification t2 where t2.id=#{id} and api_classification_id=t2.id")
    List<ApiListOV> getListByClassification(Integer id);

    @Select("select t1.*,t2.username caeateUsername from api t1,user t2 where t1.create_user=t2.id and t1.id=#{apiId}")
    @Results({
            @Result(property = "requestParams",column = "id",
                    many = @Many(select="com.kuang.mapper.ApiRequestParammapper.findAll"))
    })
    List<ApiOV> joinUsername(Integer apiId);


}
