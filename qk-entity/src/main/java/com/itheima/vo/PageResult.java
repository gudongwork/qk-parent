package com.itheima.vo;

import com.itheima.entity.Dept;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
//代表某一页的数据
public class PageResult<T> {

    private Long total;//代表总共多少数据
    private List<T> rows;//代表当前页有多少个对象

}
