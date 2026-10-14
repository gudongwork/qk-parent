package com.itheima.service;

import com.itheima.dto.DeptDTO;
import com.itheima.entity.Dept;
import com.itheima.vo.PageResult;

import java.util.List;

public interface DeptService {

    //添加部门
    void add(Dept dept);


    void update(Dept dept);

    Dept findById(Integer id);

    List<Dept> findAll();

    void deleteById(Integer id);

    PageResult<Dept> findByDTO(DeptDTO deptDTO);
}
