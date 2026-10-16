package com.itheima.service;

import com.itheima.dto.UserDTO;
import com.itheima.entity.User;
import com.itheima.vo.PageResult;

public interface UserService {
    PageResult<User> queryByPage(UserDTO userDTO);
    void update(User user);
    void add(User user);
}
