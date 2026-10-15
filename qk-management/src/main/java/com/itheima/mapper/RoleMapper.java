package com.itheima.mapper;

import com.github.pagehelper.Page;
import com.itheima.dto.RoleDTO;
import com.itheima.entity.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {
    Page<Role> selectByDTO(RoleDTO roleDTO);

    void updateById(Role role);

    @Insert("INSERT INTO role (name,label,remark,create_time,update_time) VALUES (#{name}, #{label}, #{remark}, #{createTime}, #{updateTime})")
    void insert(Role role);

    @Select("SELECT * FROM role WHERE id = #{id}")
    Role selectById(Integer id);

    @Delete("DELETE FROM role WHERE id = #{id}")
    void deleteById(Integer id);

    @Select("SELECT * FROM role")
    List<Role> selectAll();

}
