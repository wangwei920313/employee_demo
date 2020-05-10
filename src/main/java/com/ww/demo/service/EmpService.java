package com.ww.demo.service;

import com.ww.demo.dto.EmployeeDTO;
import com.ww.demo.entity.Employee;
import com.ww.demo.util.PageUtils;

import java.util.List;

public interface EmpService {

    List<Employee> list(EmployeeDTO employeeDTO);

    long count(EmployeeDTO employeeDTO);

    boolean save(EmployeeDTO dto);

    boolean check(EmployeeDTO dto);

    int delete(long id);

    EmployeeDTO info(long id);

    int update(EmployeeDTO dto);

}
