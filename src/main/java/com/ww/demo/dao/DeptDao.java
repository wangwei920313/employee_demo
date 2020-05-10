package com.ww.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ww.demo.dto.DepartmentDTO;
import com.ww.demo.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao extends BaseMapper<Department> {

    List<Department> all();

    List<DepartmentDTO> list(DepartmentDTO dto);

    long count(DepartmentDTO dto);

}
