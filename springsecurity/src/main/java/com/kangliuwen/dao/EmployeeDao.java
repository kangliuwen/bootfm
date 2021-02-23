package com.kangliuwen.dao;

import com.kangliuwen.pojo.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author klw
 * @Description(复杂调用逻辑时的描述):
 * @date 2021-01-22 16:13
 */
@Repository
public class EmployeeDao {
    private static Map<String, Employee> employees = null;
    static {
        employees = new HashMap<String, Employee>();
        employees.put("1001",new Employee("1001","张三","18900263547","123436@139.com","0",new Date(),"001"));
        employees.put("1002",new Employee("1002","李四","18900263546","123436@140.com","1",new Date(),"002"));
        employees.put("1003",new Employee("1003","王五","18900263545","123436@141.com","1",new Date(),"001"));
        employees.put("1004",new Employee("1004","李逵","18900263544","123436@142.com","0",new Date(),"001"));
    }
    public List<Employee> getEmployees(){
        List empList = new ArrayList();
        employees.forEach((key,value)->{
            empList.add(value);
        });
        return empList;
    }
    public Employee getEmployeeById(String id){
        Employee employee = new Employee();
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            if(entry.getKey().equals(id)){
                employee = entry.getValue();
            }
        }
        return employee;
    }
    private static Integer initId = 1004;
    public void addEmployee(Employee employee){
        if(StringUtils.isEmpty(employee.getEmpId())){
            employee.setEmpId((++initId).toString());
        }
        employees.put(employee.getEmpId(),employee);
    }
    public void deleteEmployee(String id){
        employees.entrySet().removeIf(entry -> entry.getKey().equals(id));
    }
}
