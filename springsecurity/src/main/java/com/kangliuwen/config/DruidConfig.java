package com.kangliuwen.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

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
 * @date 2021-01-27 16:14
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
      //后台需要人登陆，设置账户密码
        HashMap<String, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("loginUsername","kangliuwen");//登陆key，固定使用loginUsername、loginPassword
        objectObjectHashMap.put("loginPassword","123456");
        //允许谁能访问
        //禁止谁能访问
        //IP白名单
        //bean.addInitParameter("allow", "*");
        //IP黑名单(共同存在时，deny优先于allow)
        //bean.addInitParameter("deny", "192.168.1.100");
        bean.setInitParameters(objectObjectHashMap);
        return bean;
    }
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        //filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
















}
