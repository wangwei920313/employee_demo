package com.ww.demo.controller;

import com.ww.demo.dto.DataTableDTO;
import com.ww.demo.dto.DepartmentDTO;
import com.ww.demo.entity.Department;
import com.ww.demo.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dept")
@Slf4j
public class DepartmentController {

    @Autowired
    private DeptService deptService;

    /**
     * 打开首页
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("name",deptService.all().get(0).getDeptName());
        return "index";
    }

    /**
     * 查询所有部门 用于下拉框
     * @return
     */
    @GetMapping("/all")
    @ResponseBody
    public List<Department> all(){
        return deptService.all();
    }

    /**
     * 跳转部门列表
     * @param model
     * @return
     */
    @RequestMapping("/info")
    public String indexV2(Model model){
        return "department";
    }

    /**
     * 部门列表分页查询
     * @param dto
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public DataTableDTO<DepartmentDTO> list(DepartmentDTO dto){
        DataTableDTO<DepartmentDTO> dataTableDTO = new DataTableDTO<>();
        List<DepartmentDTO> list = deptService.list(dto);
        long count = deptService.count(dto);
        //封装dataTables对象  用于前端dataTables插件
        dataTableDTO.setData(list);
        dataTableDTO.setDraw(dto.getDraw());
        dataTableDTO.setRecordsFiltered((int)count);
        dataTableDTO.setRecordsTotal((int)count);
        return dataTableDTO;
    }

}
