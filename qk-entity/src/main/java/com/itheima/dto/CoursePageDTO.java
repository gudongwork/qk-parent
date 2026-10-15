package com.itheima.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursePageDTO {
    private String name;
    private Integer subject;
    private Integer target;
    private Integer page = 1;
    private Integer pageSize = 5;
}
