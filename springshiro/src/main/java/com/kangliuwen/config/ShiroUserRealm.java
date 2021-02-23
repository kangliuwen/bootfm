package com.kangliuwen.config;

import com.kangliuwen.mapper.EmployeeMapper;
import com.kangliuwen.pojo.Employee;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author klw
 * @Description(复杂调用逻辑时的描述):
 * @date 2021-02-18 11:42
 */
@Configuration
public class ShiroUserRealm extends AuthorizingRealm {

    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了-》授权doGetAuthorizationInfo");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        Employee user = (Employee)subject.getPrincipal();
        authorizationInfo.addStringPermission(user.getPerms());
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了-》认证doGetAuthenticationInfo");
        UsernamePasswordToken userToken = (UsernamePasswordToken)authenticationToken;
        List<Employee> employeeList = employeeMapper.queryUserList();
        Employee user = null;
        for (Employee employee : employeeList) {
            if(userToken.getUsername().equals(employee.getAccount())){
                user = employee;
            }
        }
        if(user==null){
            return null;
        }
        //密码认证shiro自己做
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
