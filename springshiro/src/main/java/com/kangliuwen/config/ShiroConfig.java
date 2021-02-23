package com.kangliuwen.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author klw
 * @Description(复杂调用逻辑时的描述):
 * @date 2021-02-18 11:41
 */
@Configuration
public class ShiroConfig {

    //3、ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //登陆拦截，添加shiro内置过滤器
        /**
         * anno：无需认证就可以访问
         * authc：必须认证了才能访问
         * user：必须拥有记住我才能访问
         * perms：拥有对某个资源的权限才能访问
         * role：拥有某个角色权限才能访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/level/level1/2","authc");//给/level/level1/2加登陆认证权限

        //授权，跳转到未授权页面
        filterMap.put("/user/toUpdate/*","perms[user:toUpdate]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        //设置登陆的页面
        shiroFilterFactoryBean.setLoginUrl("/tologin");
        //设置未授权的的返回
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
        return shiroFilterFactoryBean;
    }
    //2、DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") ShiroUserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //1、创建自定义realm对象，需要自定义类
    @Bean(name = "userRealm")
    public ShiroUserRealm shiroUserRealm(){
        return new ShiroUserRealm();
    }
    //整合shiroDialect，用来整合shiro thymeleaf
    @Bean
    public ShiroDialect getshiroDialect(){
        return new ShiroDialect();
    }
}
