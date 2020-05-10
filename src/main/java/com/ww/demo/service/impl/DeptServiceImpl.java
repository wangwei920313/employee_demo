package com.ww.demo.service.impl;

import com.ww.demo.dao.DeptDao;
import com.ww.demo.dto.DepartmentDTO;
import com.ww.demo.entity.Department;
import com.ww.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Department> all() {
        return deptDao.all();
    }

    @Override
    public List<DepartmentDTO> list(DepartmentDTO dto) {
        return deptDao.list(dto);
    }

    @Override
    public long count(DepartmentDTO dto) {
        return deptDao.count(dto);
    }
}
