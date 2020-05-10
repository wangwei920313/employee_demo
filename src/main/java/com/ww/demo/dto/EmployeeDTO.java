package com.ww.demo.dto;

import com.ww.demo.entity.Department;
import com.ww.demo.entity.Employee;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDTO extends Employee {

    private int page;

    private int limit;

    private int rows;

    private int draw;

    private int checkType;

    private List<Department> depts;

    private String deptName;

    private String empNumStr;

}
