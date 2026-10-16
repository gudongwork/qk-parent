package com.itheima.mapper;

import com.itheima.dto.UserDTO;
import com.itheima.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> queryByPage(UserDTO userDTO);
    void update(User user);
    void add(User user);
}
