package com.kangliuwen.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 总部接口:
 * <p>
 * 总部接口规范文档:
 * <p>
 * 省公司接口:
 * <p>
 * 省公司接口规范文档:
 *
 * @author klw
 * @Description(复杂调用逻辑时的描述):
 * @date 2021-01-28 15:48
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/mystatic/css/**","/mystatic/js/**");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，功能页只有对应权限的人才能访问
        //请求授权规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level/level1/**").hasRole("vip1")//对level/level1/下的需要vip1权限
                .antMatchers("/level/level2/**").hasRole("vip2")//对level/level2/下的需要vip2权限
                .antMatchers("/level/level3/**").hasRole("vip3")//对level/level3/下的需要vip3权限
                //.anyRequest().permitAll()//其他没有限定的请求，允许访问
                //.and().anonymous()//对于没有配置权限的其他请求允许匿名访问
                .and().formLogin()//使用spring security 默认登录页面
                .loginPage("/tologin") // default is /login  自定义登录页url,默认为/login
                .loginProcessingUrl("/user/login")//登录请求拦截的url,也就是form表单提交时指定的action
                //.loginProcessingUrl("/login")//登录请求拦截的url,也就是form表单提交时指定的action
                .failureUrl("/404").defaultSuccessUrl("/index")
                .usernameParameter("account"); // default is username
        //注销
        //http.logout().deleteCookies().invalidateHttpSession(false);
        http.logout().invalidateHttpSession(false);
        http.logout().logoutUrl("/user/logout");
        http.rememberMe().rememberMeParameter("remember");//Cookie的实现，记住我
                http.csrf().disable();//不允许跨域
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //这些数据正常从数据库读
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("guest").password(new BCryptPasswordEncoder().encode("1")).roles("vip1").and()
                .withUser("kangliuwen").password(new BCryptPasswordEncoder().encode("1")).roles("vip1","vip2").and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("1")).roles("vip1","vip2","vip3");

    }
}
