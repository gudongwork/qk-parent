package com.itheima.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptDTO {

    private String name;
    private Integer status;
    private Integer page = 1; //默认第一页
    private Integer pageSize = 10; //默认每页显示10条数据

    private Long start;

}
