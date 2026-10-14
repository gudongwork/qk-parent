package com.itheima.controller;

import com.itheima.dto.CoursePageDTO;
import com.itheima.entity.Course;
import com.itheima.service.CoursesService;
import com.itheima.vo.PageResult;
import com.itheima.vo.Result;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CoursesService coursesService;
    @GetMapping
    public Result queryPage(CoursePageDTO coursePageDTO) {
        PageResult<Course> pageResult = coursesService.queryPage(coursePageDTO);
        Result result = new Result();
        result.setData(pageResult);
        result.setCode(0);
        result.setMsg("查询成功");
        result.setData(pageResult);
        return result;
    }
    @PutMapping
    public Result update(@RequestBody Course course) {
        coursesService.update(course);
        return new Result(0, "修改成功", new Object());
    }
    @PostMapping
    public Result add(@RequestBody Course course){
        coursesService.add(course);
        return new Result(0, "添加成功", new Object());
    }
    @GetMapping("/{id}")
    public Result getCourseById(@PathVariable Integer id){
        Course course = coursesService.getCourseById(id);
        return new Result(0, "查询成功", course);
    }
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        coursesService.deleCourseById(id);
        return new Result(0,"删除成功",new Object());
    }
    @GetMapping("/list")
    public Result queryAll(){
        List<Course> courses = coursesService.queryAll();
        return new Result(0, "查询成功", courses);
    }
}
