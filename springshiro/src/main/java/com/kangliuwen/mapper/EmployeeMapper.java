package com.kangliuwen.mapper;

import com.kangliuwen.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
 * @date 2021-01-27 17:21
 */
@Mapper
@Repository
public interface EmployeeMapper {
     List<Employee> queryUserList();
}
