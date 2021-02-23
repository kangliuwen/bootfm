package com.kangliuwen.dao;

import com.kangliuwen.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author klw
 * @Description(复杂调用逻辑时的描述):
 * @date 2021-01-22 16:08
 */
@Repository
public class DepartmentDao {

    private static Map<String, Department> departments = null;
    static {
        departments = new HashMap<String, Department>();
        departments.put("001",new Department("001","开发部"));
        departments.put("002",new Department("002","后勤部"));
    }

    public List<Department> getDepartmentList(){
        List departList = new ArrayList();
        departments.forEach((key,value)->{
            departList.add(value);
        });
        return departList;
    }
    public Department getDepartmentById(String id){
        Department department = new Department();
        for (Map.Entry<String, Department> entry : departments.entrySet()) {
            if(entry.getKey().equals(id)){
                department = entry.getValue();
            }
        }
        return department;
    }
    public void addDepartment(Department department){
        departments.put(department.getDepId(),department);
    }
    public void deleteDepartmente(String id){
        departments.entrySet().removeIf(entry -> entry.getKey().equals(id));
    }

}
