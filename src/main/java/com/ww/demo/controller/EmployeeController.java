package com.ww.demo.controller;

import com.ww.demo.dto.DataTableDTO;
import com.ww.demo.dto.EmployeeDTO;
import com.ww.demo.entity.Department;
import com.ww.demo.entity.Employee;
import com.ww.demo.service.DeptService;
import com.ww.demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmpService empService;

    @Autowired
    private DeptService deptService;

    /**
     * 员工管理分页查询
     * @param dto
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public DataTableDTO<Employee> list(EmployeeDTO dto){
        DataTableDTO<Employee> dataTableDTO = new DataTableDTO<>();
        long count = empService.count(dto);
        dataTableDTO.setData(empService.list(dto));
        dataTableDTO.setDraw(dto.getDraw());
        dataTableDTO.setRecordsTotal((int)count);
        dataTableDTO.setRecordsFiltered((int)count);
        return dataTableDTO;
    }

    /**
     * 跳转员工列表
     * @param dto
     * @param model
     * @return
     */
    @GetMapping("/info")
    public String info(EmployeeDTO dto,Model model){
        List<Department> depts = deptService.all();
        model.addAttribute("depts",depts);
        model.addAttribute("deptNum",dto.getDeptNum());
        return "employee";
    }

    /**
     * 新增员工
     * @param dto
     * @param model
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public Map<String,Object> save(EmployeeDTO dto, Model model){
        Map<String,Object> map = new HashMap<>();
        map.put("result",empService.save(dto));
        map.put("msg","");
        return map;
    }

    /**
     * 检查是否重名  重身份证明  重电话号码
     * @param dto
     * @return
     */
    @GetMapping("/check")
    @ResponseBody
    public boolean check(EmployeeDTO dto){
        return empService.check(dto);
    }

    /**
     * 删除员工
     * @param empNum
     * @return
     */
    @GetMapping("/delete")
    @ResponseBody
    public boolean delete(long empNum){
        int result =  empService.delete(empNum);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 查询单个员工
     * @param empNum
     * @return
     */
    @GetMapping("/get")
    @ResponseBody
    public EmployeeDTO get(long empNum){
        return empService.info(empNum);
    }

    /**
     * 编辑更新
     * @param dto
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public Map<String,Object> update(EmployeeDTO dto){
        Map<String,Object> map = new HashMap<>();
        int result = empService.update(dto);
        if(result>0){
            map.put("result",true);
        }else{
            map.put("result",false);
        }
        map.put("msg","");
        return map;
    }

}
