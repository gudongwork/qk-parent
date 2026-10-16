package com.itheima.service;

import com.itheima.dto.UserDTO;
import com.itheima.entity.User;
import com.itheima.vo.PageResult;

import java.util.List;

public interface UserService {
    PageResult<User> queryByPage(UserDTO userDTO);
    void update(User user);
    void add(User user);
    User queryById(Integer id);
    List<User> queryByRoleLabel(String roleLabel);
    List<User> queryAll();
    List<User> queryByDeptId(String deptId);

    void delete(List<Integer> ids);
}
