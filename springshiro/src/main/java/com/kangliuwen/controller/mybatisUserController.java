package com.kangliuwen.controller;

import com.kangliuwen.mapper.EmployeeMapper;
import com.kangliuwen.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
 * @date 2021-01-27 17:23
 */
@Controller
@RequestMapping("/mybatisuser")
public class mybatisUserController {

    @Autowired
    EmployeeMapper employeeMapper;
    @RequestMapping("/users")
    public String users(Model model){
        List<Employee> employees = employeeMapper.queryUserList();
        model.addAttribute("employees",employees);
        return "users_mybatis";
    }
}
