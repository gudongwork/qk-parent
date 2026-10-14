package com.itheima.controller;

import com.itheima.entity.Dept;
import com.itheima.entity.Result;
import org.springframework.web.bind.annotation.*;

@RestController // 表示这是一个控制器类
@RequestMapping("/depts") // 表示这个类处理的请求路径的前缀是/depts
public class DeptController {

    //添加部门
    @PostMapping // 表示这个方法处理的请求方式是POST
    // @RequestBody 添加到形参上，代表让SpringMVC去请求体中获取数据，并转换成javabean
    public Result add(@RequestBody Dept dept){

        System.out.println("接收到了前端的请求："+dept);

        return Result.success("添加成功");
    }





}
