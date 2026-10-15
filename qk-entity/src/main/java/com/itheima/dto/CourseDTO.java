package com.itheima.dto;

import lombok.Data;

@Data
public class CourseDTO {

    private String name;
    private Integer subject;
    private Integer target;
    private Integer page = 1;
    private Integer pageSize = 10;

}
