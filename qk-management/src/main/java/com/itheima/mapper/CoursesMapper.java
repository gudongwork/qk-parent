package com.itheima.mapper;

import com.itheima.dto.CoursePageDTO;
import com.itheima.entity.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CoursesMapper {
    List<Course> queryPage(CoursePageDTO coursePageDTO);
    void update(Course course);
    @Update("insert into courses (name, teacher, price, status, create_time, update_time) values (#{name}, #{teacher}, #{price}, #{status}, #{createTime}, #{updateTime})")
    void add(Course course);
    @Select("select * from course where id = #{id}")
    Course getCourseById(Integer id);
    @Delete("delete from course where id = #{id}")
    void deletCourseById(Integer id);
    @Select("select * from course")
    List<Course> queryAll();
    @Select("select * from course where subject = #{subject}")
    List<Course> findBySubject(String subject);
}
