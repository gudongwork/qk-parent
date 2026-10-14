package com.itheima.service;

import com.itheima.dto.CourseDTO;
import com.itheima.entity.Course;
import com.itheima.vo.PageResult;

import java.util.List;

public interface CourseService {
    void add(Course course);

    Course findById(Integer id);

    void updateById(Course course);

    void deleteById(Integer id);

    List<Course> findBySubject(String subject);

    List<Course> findAll();

    PageResult<Course> findByDTO(CourseDTO courseDTO);
}
