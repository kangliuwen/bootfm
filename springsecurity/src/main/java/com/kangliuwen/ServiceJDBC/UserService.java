package com.kangliuwen.ServiceJDBC;

import com.kangliuwen.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
 * @date 2021-01-27 10:57
 */
@Service
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Employee> users(){
        List<Employee> employeeList = new ArrayList<>();
        List<Map<String,Object>> mapList = jdbcTemplate.queryForList("select empId,empName,empPhone,empEmail,empGender,empBirthday,deptId  from mybatis.user ");
        mapList.forEach(map->{
            Employee employee = new Employee();
            employee.setEmpId(map.get("empId").toString());
            employee.setEmpName(map.get("empName").toString());
            employee.setDeptId(map.get("deptId").toString());
            employee.setEmpEmail(map.get("empEmail").toString());
            employee.setEmpGender(map.get("empGender").toString());
            employee.setEmpPhone(map.get("empPhone").toString());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                employee.setEmpBirthday(format.parse(map.get("empBirthday").toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            employeeList.add(employee);
        });
        return employeeList;
    }

}
