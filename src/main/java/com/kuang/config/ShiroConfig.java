package com.kuang.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@EnableAutoConfiguration
@Configuration
public class ShiroConfig {

    //  创建对象需要realm
    @Bean
    public MyRealm myRealm(){
        return new MyRealm();
    }
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("myRealm") MyRealm myRealm){
        DefaultWebSecurityManager Manager = new DefaultWebSecurityManager();
//      切换session管理器
        Manager.setSessionManager(sessionManager());
        Manager.setRealm(myRealm());
        return Manager;
    }

    //  anon:无需认证
//  authc:必须认证了才能访问
//  user:必须拥有记住我功能
//  perms:拥有对某个资源的权限才能访问
//  role:拥有某个角色权限才能访问
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager")
                                                                     DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);
        Map<String, String> onMap=new LinkedHashMap<>();
        onMap.put("/user/register","anon");
        onMap.put("/user/find","anon");
        onMap.put("/user/login","anon");


        onMap.put("/**","authc");
        bean.setFilterChainDefinitionMap(onMap);
//      设置登录的请求
//        bean.setLoginUrl("/user/login");
        bean.setLoginUrl("/user/unauth");
//        未授权页面
        bean.setUnauthorizedUrl("/user/unauth");
        return bean;

    }
//  切换session管理器
    @Bean
    public SessionManager sessionManager(){
        CustomSessionManager manager = new CustomSessionManager();
		/*使用了shiro自带缓存，
		如果设置 redis为缓存需要重写CacheManager（其中需要重写Cache）
		manager.setCacheManager(this.RedisCacheManager());*/

        manager.setSessionDAO(new EnterpriseCacheSessionDAO());
        return manager;
    }


}

