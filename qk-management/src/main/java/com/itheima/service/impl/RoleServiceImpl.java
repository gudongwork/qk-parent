package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dto.RoleDTO;
import com.itheima.entity.Role;
import com.itheima.mapper.RoleMapper;
import com.itheima.service.RoleService;
import com.itheima.vo.PageResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;

    @Override
    public PageResult<Role> findByDTO(RoleDTO roleDTO) {
        PageHelper.startPage(roleDTO.getPage(), roleDTO.getPageSize());

        Page<Role> page = roleMapper.selectByDTO(roleDTO);

        PageResult<Role> pageResult = new PageResult<>();

        pageResult.setTotal(page.getTotal());
        pageResult.setRows(page.getResult());

        return pageResult;
    }

    @Override
    public void updateById(Role role) {
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.updateById(role);
    }

    @Override
    public void add(Role role) {
        role.setUpdateTime(LocalDateTime.now());
        role.setCreateTime(LocalDateTime.now());
        roleMapper.insert(role);
    }

    @Override
    public Role findById(Integer id) {
        return roleMapper.selectById(id);
    }

    @Override
    public void deleteById(Integer id) {
        roleMapper.deleteById(id);
    }

    @Override
    public List<Role> findAll() {
        return roleMapper.selectAll();
    }
}
