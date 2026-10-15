package com.itheima.mapper;

import com.itheima.dto.DeptDTO;
import com.itheima.entity.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Insert("insert into dept(name,status,create_time,update_time) values(#{name},#{status},#{createTime},#{updateTime}) ")
    void insert(Dept dept);

    void updateById(Dept dept);

    @Select("select * from dept where id=#{id}")
    Dept selectById(Integer id);

    @Select("select * from dept")
    List<Dept> selectAll();

    @Delete("delete from dept where id=#{id}")
    void deleteById(Integer id);

    Long count(DeptDTO deptDTO);

    List<Dept> selectByPage(DeptDTO deptDTO);

    List<Dept> selectByDTO(DeptDTO deptDTO);
}
