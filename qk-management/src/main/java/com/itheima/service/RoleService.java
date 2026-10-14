package com.itheima.service;

import com.itheima.dto.RoleDTO;
import com.itheima.entity.Role;
import com.itheima.vo.PageResult;

import java.util.List;

public interface RoleService {
    PageResult<Role> findByDTO(RoleDTO roleDTO);

    void updateById(Role role);

    void add(Role role);

    Role findById(Integer id);

    void deleteById(Integer id);

    List<Role> findAll();
}
