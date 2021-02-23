package com.kangliuwen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author klw
 * @Description(复杂调用逻辑时的描述):
 * @date 2021-01-22 15:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String empId;
    private String empName;
    private String empPhone;
    private String empEmail;
    private String empGender;
    private Date empBirthday;
    private String deptId;
    private String account;
    private String password;

}
