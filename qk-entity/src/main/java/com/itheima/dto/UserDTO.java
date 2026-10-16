package com.itheima.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String name;
    private Integer status;
    private String phone;
    private Integer deptId;
    private Integer page;
    private Integer pageSize;
}
