package com.ww.demo.service.impl;

import com.ww.demo.dao.DeptDao;
import com.ww.demo.dao.EmpDao;
import com.ww.demo.dto.EmployeeDTO;
import com.ww.demo.entity.Department;
import com.ww.demo.entity.Employee;
import com.ww.demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Autowired
    private DeptDao deptDao;

    public List<Employee> list(EmployeeDTO dto){
        return empDao.list(dto);
    }

    @Override
    public long count(EmployeeDTO dto) {
        return empDao.count(dto);
    }

    @Override
    @Transactional
    public boolean save(EmployeeDTO dto) {
        return empDao.save(dto);
    }

    @Override
    public boolean check(EmployeeDTO dto) {
        long count = 0L;
        switch (dto.getCheckType()){
            case 1:
                count=empDao.checkName(dto.getEmpName());
                break;
            case 2:
                count=empDao.checkIdCard(dto.getIdCard());
                break;
            case 3:
                count=empDao.checkPhoneNum(dto.getPhoneNum());
                break;
            default:
                count = 0;
        }
        if(count>0){
            //出现重复数据
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public int delete(long id) {
        return empDao.delete(id);
    }

    @Override
    public EmployeeDTO info(long id) {
        List<Department> depts = deptDao.all();
        EmployeeDTO dto = empDao.info(id);
        dto.setDepts(depts);
        return dto;
    }

    @Override
    @Transactional
    public int update(EmployeeDTO dto) {
        return empDao.update(dto);
    }
}
