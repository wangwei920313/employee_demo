package com.ww.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class DataTableDTO<T> {

    private List<T> data; //data 与datatales 加载的“dataSrc"对应

    private int recordsTotal;

    private int recordsFiltered;

    private int draw;

}
