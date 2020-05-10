package com.ww.demo.dao;

import com.ww.demo.dto.EmployeeDTO;
import com.ww.demo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpDao {

    List<Employee> list(EmployeeDTO dto);

    long count(EmployeeDTO dto);

    boolean save(EmployeeDTO dto);

    long checkName(String deptName);

    long checkPhoneNum(String phoneNum);

    long checkIdCard(String idCard);

    int delete(long id);

    EmployeeDTO info(long id);

    int update(EmployeeDTO dto);

}
