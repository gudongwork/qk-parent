package com.itheima.service;

import com.itheima.dto.CoursePageDTO;
import com.itheima.entity.Course;
import com.itheima.vo.PageResult;

import java.util.List;

public interface CoursesService {
    PageResult<Course> queryPage(CoursePageDTO coursePageDTO);
    void update(Course course);
    void add(Course course);
    Course getCourseById(Integer id);

    void deleCourseById(Integer id);

    List<Course> queryAll();
}
