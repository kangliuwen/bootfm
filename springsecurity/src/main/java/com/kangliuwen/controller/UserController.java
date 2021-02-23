package com.kangliuwen.controller;

import com.kangliuwen.dao.DepartmentDao;
import com.kangliuwen.dao.EmployeeDao;
import com.kangliuwen.pojo.Department;
import com.kangliuwen.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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
 * @date 2021-01-25 15:54
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/users")
    public String users(Model model){
        List<Employee> employees = employeeDao.getEmployees();
        model.addAttribute("employees",employees);
        return "users";
    }
    @GetMapping("/addUser")
    public String toAdd(Employee employee, Model model){
        List<Department> departmentList = departmentDao.getDepartmentList();
        model.addAttribute("departments",departmentList);
        return "addUser";
    }
    @PostMapping("/addUser")
    public String addUser(Employee employee){
        employeeDao.addEmployee(employee);
        return "redirect:/user/users";
    }
    @GetMapping("/toUpdate/{empId}")
    public String toUpdate(@PathVariable("empId") String empId, Model model){
        List<Department> departmentList = departmentDao.getDepartmentList();
        model.addAttribute("departments",departmentList);
        Employee employee = employeeDao.getEmployeeById(empId);
        model.addAttribute("employee",employee);
        return "updateUser";
    }
    @PostMapping("/toUpdate")
    public String toUpdate(Employee employee){
        employeeDao.addEmployee(employee);
        return "redirect:/user/users";
    }
    @GetMapping("/deleteUser/{empId}")
    public String deleteUser(@PathVariable("empId") String empId){
        employeeDao.deleteEmployee(empId);
        return "redirect:/user/users";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }

}
