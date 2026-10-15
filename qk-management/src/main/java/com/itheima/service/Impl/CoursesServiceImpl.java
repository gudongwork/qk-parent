package com.itheima.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dto.CoursePageDTO;
import com.itheima.entity.Course;
import com.itheima.mapper.CoursesMapper;
import com.itheima.service.CoursesService;
import com.itheima.vo.PageResult;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Service
@RequiredArgsConstructor
public class CoursesServiceImpl implements CoursesService {
    private final CoursesMapper coursesMapper;

    @Override
    public void add(Course course) {
        course.setCreateTime(LocalDateTime.now());
        course.setUpdateTime(LocalDateTime.now());
        coursesMapper.add(course);
    }

    @Override
    public Course getCourseById(Integer id) {
        return coursesMapper.getCourseById(id);
    }

    @Override
    public void deleCourseById(Integer id) {
        coursesMapper.deletCourseById(id);
    }

    @Override
    public List<Course> queryAll() {
        return coursesMapper.queryAll();
    }

    @Override
    public List<Course> findBySubject(String subject) {
        return coursesMapper.findBySubject(subject);
    }

    @Override
    public void update(Course course) {
        course.setUpdateTime(LocalDateTime.now());
        coursesMapper.update(course);
    }

    @Override
    public PageResult<Course> queryPage(CoursePageDTO coursePageDTO) {
        PageResult<Course> pageResult = new PageResult<>();
        PageHelper.startPage(coursePageDTO.getPage(), coursePageDTO.getPageSize());
        List<Course> courses = coursesMapper.queryPage(coursePageDTO);
        Page<Course> page = (Page<Course>) courses;
        System.out.println("11111"+page.getResult());
        pageResult.setTotal(page.getTotal());
        pageResult.setRows(page.getResult());
        for(Course course : page.getResult()){
            System.out.println(course);
        }
        return pageResult;
    }
}
