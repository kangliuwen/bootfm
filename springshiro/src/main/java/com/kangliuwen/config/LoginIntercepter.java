package com.kangliuwen.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * @date 2021-01-25 15:23
 */
public class LoginIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //在Shiro中做了认证和授权，所以这里不需要了
        /*Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser==null){
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }*/
        return true;
    }
}
