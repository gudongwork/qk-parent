package com.itheima.controller;

import com.itheima.dto.DeptDTO;
import com.itheima.entity.Dept;
import com.itheima.vo.PageResult;
import com.itheima.vo.Result;
import com.itheima.service.DeptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 表示这是一个控制器类
@RequestMapping("/depts") // 表示这个类处理的请求路径的前缀是/depts
@RequiredArgsConstructor
@Slf4j // 开启日志功能
public class DeptController {

    private final DeptService deptService;

    //添加部门
    @PostMapping // 表示这个方法处理的请求方式是POST
    // @RequestBody 添加到形参上，代表让SpringMVC去请求体中获取数据，并转换成javabean
    public Result add(@RequestBody Dept dept){
        log.info("接收到了前端的请求：{}",dept);
        //log的四种级别
        log.debug("这个是debug级别的日志");
        log.info("这个是info级别的日志");
        log.warn("这个是warn级别的日志");
        log.error("这个是error级别的日志");

        deptService.add(dept);
        return Result.success("添加成功");
    }


    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("接收到了前端的请求：{}",dept);

        deptService.update(dept);

        return Result.success("更新成功");
    }


    //根据id查询部门对象
    @GetMapping("/{id}")
    //@PathVariable  代表从路径中获取参数，必须有
    public Result findById(@PathVariable Integer id){
        log.info("接收到了前端的请求：{}",id);

        Dept dept = deptService.findById(id);

        return Result.success(dept);
    }


    @GetMapping("/list")
    public Result findAll(){
        log.info("接收到了前端的请求");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        log.info("接收到了前端的请求：{}",id);
        deptService.deleteById(id);
        return Result.success("删除成功");
    }


    //分页查询
    @GetMapping
    public Result findByPage(DeptDTO deptDTO){
        log.info("接收到了前端的请求：{}",deptDTO);

       PageResult<Dept> pageResult =  deptService.findByDTO(deptDTO);

        return Result.success(pageResult);
    }




}
