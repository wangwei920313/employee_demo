package com.ww.demo.dto;

import com.ww.demo.entity.Department;
import lombok.Data;

@Data
public class DepartmentDTO extends Department {

    private int page;

    private int limit;

    private int rows;

    private int draw;

    private String pName;

}
