package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dto.UserDTO;
import com.itheima.entity.User;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import com.itheima.vo.PageResult;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Data
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Override
    public PageResult<User> queryByPage(UserDTO userDTO) {
        PageResult<User> result = new PageResult<>();
        PageHelper.startPage(userDTO.getPage(),userDTO.getPageSize());
        List<User> userList = userMapper.queryByPage(userDTO);
        Page<User> page = (Page<User>) userList;
        result.setTotal(page.getTotal());
        result.setRows(page.getResult());
        return result;
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void add(User user) {
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.add(user);
    }

    @Override
    public User queryById(Integer id) {
        return userMapper.queryById(id);
    }

    @Override
    public List<User> queryByRoleLabel(String roleLabel) {
        return userMapper.queryByRoleLabel(roleLabel);
    }

    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    @Override
    public List<User> queryByDeptId(String deptId) {
        return userMapper.queryByDeptId(deptId);
    }

    @Override
    public void delete(List<Integer> ids) {
        StringBuilder sqlStr = new StringBuilder();
        for(int i = 0; i < ids.size(); i++){
            sqlStr.append(ids.get(i));
            if (i == ids.size() - 1) break;
            sqlStr.append(",");
        }
        userMapper.delete(sqlStr.toString());
    }
}
