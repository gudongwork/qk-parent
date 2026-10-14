package com.itheima.controller;

import com.itheima.dto.CourseDTO;
import com.itheima.entity.Course;
import com.itheima.service.CourseService;
import com.itheima.vo.PageResult;
import com.itheima.vo.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 课程管理模块
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    //分页查询
    @GetMapping
    public Result findByPage(CourseDTO courseDTO){
        log.info("接收到的分页查询参数：{}", courseDTO);
        PageResult<Course> pageResult = courseService.findByDTO(courseDTO);
        return Result.success(pageResult);
    }

    //修改课程
    @PutMapping
    public Result put(@RequestBody Course course){
        log.info("接收到的课程信息：{}", course);
        courseService.updateById(course);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Course course){
        log.info("接收到的课程信息：{}", course);
        courseService.add(course);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("接收到的id：{}", id);
        Course course = courseService.findById(id);
        return Result.success(course);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("接收到的id：{}", id);
        courseService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/subject/{subject}")
    public Result findBySubject(@PathVariable String subject){
        log.info("接收到的科目：{}", subject);
        List<Course> courseList = courseService.findBySubject(subject);
        return Result.success(courseList);
    }

    @GetMapping("/list")
    public Result findAll(){
        log.info("查询所有课程");
        List<Course> courseList = courseService.findAll();
        return Result.success(courseList);
    }

}
