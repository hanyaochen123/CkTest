package com.kuang.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuang.pojo.User;
import com.kuang.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    UserService service;
//  授权（权限管理）
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
//  身份认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username=authenticationToken.getPrincipal().toString();
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username",username);
        User one = service.getOne(userQueryWrapper);
        if (one!=null){
//            if (one.getPassword().equals(authenticationToken.getCredentials())){
//            }
            return new SimpleAuthenticationInfo(one,one.getPassword(),getName());

        }

        return null;
    }
}
