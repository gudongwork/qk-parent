package com.itheima.dto;

import lombok.Data;

@Data
public class RoleDTO {

    private String name;
    private String label;
    private Integer page = 1;
    private Integer pageSize = 10;

}
