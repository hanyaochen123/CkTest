package com.kuang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuang.common.Result;
import com.kuang.pojo.Project;
import com.kuang.pojo.User;
import com.kuang.service.ProjectService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    /**
     * 登录之后显示在界面上的项目，由账号控制权限
     */
    @GetMapping("/toList")
    public Result toList(Integer userId){
        Result result=null;
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("create_user",userId);
        List list = projectService.list(wrapper);
        result =new Result("1",list,"项目列表");
        return result;
    }
    @PostMapping("/add")
    public Result add(Project project){
        Result result=null;
        User user= (User) SecurityUtils.getSubject().getPrincipal();
        project.setCreateUser(user.getId());
        projectService.save(project);
        result =new Result("1","新增成功");
        return result;

    }
    @GetMapping("/{projectid}")
    public Result getByid(@PathVariable Integer projectid){
        Result result=null;
        Project byId = projectService.getById(projectid);
        result =new Result("1",byId,"查询项目");
        return result;
    }
    @PutMapping("/{updateByid}")
    public Result updateByid(@PathVariable Integer updateByid,Project project){
        Result result=null;
        project.setId(updateByid);
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        project.setCreateUser(user.getId());
        projectService.updateById(project);
        result =new Result("1",project,"更新项目");
        return result;
    }
    @DeleteMapping("/{deleteid}")
    public Result deleteById(@PathVariable Integer deleteid){
        Result result=null;
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        user.getId();
        projectService.removeById(deleteid);
        result =new Result("1","删除成功");
        return result;
    }

}
