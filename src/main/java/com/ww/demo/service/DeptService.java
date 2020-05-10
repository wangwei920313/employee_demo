package com.ww.demo.service;

import com.ww.demo.dto.DepartmentDTO;
import com.ww.demo.entity.Department;

import java.util.List;

public interface DeptService {

    public List<Department> all();

    List<DepartmentDTO> list(DepartmentDTO dto);

    long count(DepartmentDTO dto);

}
