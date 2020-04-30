package com.kuang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuang.common.Result;
import com.kuang.mapper.Usermapper;
import com.kuang.pojo.User;
import com.kuang.service.UserService;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Date;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public Result resulter(User user){
        userService.save(user);

        Result result=new Result("1","注册成功");
        return result;

    }
    @GetMapping("/find")
    public Result find(String username){
        Result result=null;
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("username", username);
        User one = userService.getOne(wrapper);
        if (one==null){
            result=new Result("1","注册成功");
        }else {
            result=new Result("0","用户名已存在");
        }
        return result;
    }
    @PostMapping("/login")
    public Result login(User user){
        Result result;
        try{
            UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            String sessionid = (String) SecurityUtils.getSubject().getSession().getId();
            User principal = (User) subject.getPrincipal();

            result=new Result("0",principal.getId(),sessionid);
        }catch (AuthenticationException e){
            if (e instanceof UnknownAccountException){
                result=new Result("1","用户名错误");
            }else {
                result=new Result("1","密码错误");
            }
            e.printStackTrace();
        }
        return result;
    }
    @GetMapping("/logout")
    public Result logout(){
        Result result;
        SecurityUtils.getSubject().logout();
        result=new Result("0","用户已退出");
        return result;

    }
    @GetMapping("/unauth")
    public Result unauth(){
        Result result=null;
        result=new Result("0","用户未登录");
        return result;

    }




}
