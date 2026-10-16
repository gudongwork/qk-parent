package com.itheima.controller;

import com.itheima.dto.ActivityDTO;
import com.itheima.entity.Activity;
import com.itheima.service.ActivityService;
import com.itheima.vo.PageResult;
import com.itheima.vo.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/activities")
@Slf4j
public class ActivityController {
    private final ActivityService activityService;
    @GetMapping
    public Result queryPage(ActivityDTO activityDTO) {
        PageResult<Activity> pageResult = activityService.queryPage(activityDTO);
        Result result = new Result();
        result.setData(pageResult);
        result.setCode(1);
        result.setMsg("查询成功");
        result.setData(pageResult);
        return result;
    }
    @PutMapping
    public Result update(@RequestBody Activity activity) {
        activityService.update(activity);
        return new Result(1, "修改成功", new Object());
    }
    @PostMapping
    public Result add(@RequestBody Activity activity){
        System.out.println("-------------");
        System.out.println(activity);
        activityService.add(activity);
        return new Result(1, "添加成功", new Object());
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Activity activity = activityService.getById(id);
        return new Result(1, "查询成功", activity);
    }
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        activityService.deleById(id);
        return new Result(1,"删除成功",new Object());
    }
    @GetMapping("/list")
    public Result queryAll(){
        List<Activity> activities = activityService.queryAll();
        return new Result(1, "查询成功", activities);
    }
}
