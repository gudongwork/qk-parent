package com.itheima.mapper;

import com.itheima.dto.CourseDTO;
import com.itheima.entity.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Insert("INSERT INTO course (name, subject, price, target, description, create_time, update_time) VALUES (#{name}, #{subject}, #{price}, #{target}, #{description}, #{createTime}, #{updateTime})")
    void insert(Course course);

    @Select("SELECT * FROM course WHERE id = #{id}")
    Course selectById(Integer id);

    void updateById(Course course);

    @Delete("DELETE FROM course WHERE id = #{id}")
    void deleteById(Integer id);

    @Select("SELECT * FROM course WHERE subject = #{subject}")
    List<Course> selectBySubject(String subject);

    @Select("SELECT * FROM course")
    List<Course> selectAll();

    List<Course> selectByDTO(CourseDTO courseDTO);
}
