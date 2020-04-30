package com.kuang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuang.common.ApiClassificationOV;
import com.kuang.common.Result;
import com.kuang.pojo.ApiClassification;
import com.kuang.pojo.User;
import com.kuang.service.ApiClassificationService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/apiClassification")
public class ApiClassificationController {
    @Autowired
    ApiClassificationService apiClassificationService;
    @GetMapping("toindex")
    public Result getWithList(Integer projectId,Integer tab){
        Result result = null;
        if (tab==1){
            List<ApiClassificationOV> withList = apiClassificationService.getWithList(projectId);
            result=new Result("1",withList,"查询分类同时也延迟加载api");
        }else{

        }
        return result;
    }
    @PostMapping("/addApiClass")
    public Result addApiClass(ApiClassification apiClassification){
        Result result=null;
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        apiClassification.setCreateUser(user.getId());
        System.out.println("555"+user.getId());
        System.out.println("666"+apiClassification);
        apiClassificationService.save(apiClassification);
        result=new Result("1","新增成功");
        return result;
    }
    @DeleteMapping("/{deleteById}")
    public Result deleteById(@PathVariable Integer deleteById){
        Result result=null;
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        System.out.println(user);
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        user.getId();
        apiClassificationService.removeById(deleteById);
        result =new Result("1","删除成功");
        return result;
    }
    @PutMapping("/{updateById}")
    public Result updateByid(@PathVariable Integer updateById,ApiClassification apiClassification){
        Result result=null;
        apiClassification.setId(updateById);
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        user.getId();
        apiClassificationService.updateById(apiClassification);
        result =new Result("1",apiClassification,"更新成功");
        return result;
    }
    @GetMapping("findAll")
    public Result findAll(Integer projectId){
        Result result=null;
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("project_id",projectId);
        List list = apiClassificationService.list(queryWrapper);
        result =new Result("1",list);
        return result;

    }



}
