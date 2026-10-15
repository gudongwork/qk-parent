package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dto.CourseDTO;
import com.itheima.entity.Course;
import com.itheima.mapper.CourseMapper;
import com.itheima.service.CourseService;
import com.itheima.vo.PageResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseMapper courseMapper;

    @Override
    public void add(Course course) {
        course.setUpdateTime(LocalDateTime.now());
        course.setCreateTime(LocalDateTime.now());
        courseMapper.insert(course);
    }

    @Override
    public Course findById(Integer id) {
        return courseMapper.selectById(id);
    }

    @Override
    public void updateById(Course course) {
        course.setUpdateTime(LocalDateTime.now());
        courseMapper.updateById(course);
    }

    @Override
    public void deleteById(Integer id) {
        courseMapper.deleteById(id);
    }

    @Override
    public List<Course> findBySubject(String subject) {
        return courseMapper.selectBySubject(subject);
    }

    @Override
    public List<Course> findAll() {
        return courseMapper.selectAll();
    }

    @Override
    public PageResult<Course> findByDTO(CourseDTO courseDTO) {
        PageHelper.startPage(courseDTO.getPage(), courseDTO.getPageSize());
        Page<Course> page = (Page<Course>) courseMapper.selectByDTO(courseDTO);
        PageResult<Course> pageResult = new PageResult<>();
        pageResult.setTotal(page.getTotal());
        pageResult.setRows(page.getResult());
        return pageResult;
    }
}
