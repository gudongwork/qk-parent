package com.itheima.mapper;

import com.itheima.dto.UserDTO;
import com.itheima.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> queryByPage(UserDTO userDTO);
    void update(User user);
    void add(User user);
    @Select("select * from user where id = #{id}")
    User queryById(Integer id);
    @Select("select u.id,username,password,u.name,phone,email,gender,status,dept_id,role_id,image,u.remark,u.create_time,u.update_time  from user as u left join role as r on u.role_id = r.id where r.label = #{roleLabel}")
    List<User> queryByRoleLabel(String roleLabel);
    @Select("select * from user")
    List<User> queryAll();
    @Select("select * from user where dept_id = #{deptId}")
    List<User> queryByDeptId(String deptId);
    @Delete("delete from user where id in (${ids})")
    void delete(String ids);
}
