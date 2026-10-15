package com.itheima.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDTO {
    private Integer channel;
    private Integer type;
    private Integer status;
    private Integer page;
    private Integer pageSize;
}
