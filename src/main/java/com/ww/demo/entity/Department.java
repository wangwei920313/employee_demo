package com.ww.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {

    private Long id;

    private String deptNum;

    private String deptName;

    private String pNum;

    private int isDel;

}
