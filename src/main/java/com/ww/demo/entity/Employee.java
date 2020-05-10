package com.ww.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    private Long empNum;

    private String deptNum;

    private String empName;

    private String jobNum;

    private String idCard;

    private String phoneNum;

    private String email;

    private String password;

}
