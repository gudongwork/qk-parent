package com.itheima.service;

import com.itheima.dto.ActivityDTO;
import com.itheima.dto.CoursePageDTO;
import com.itheima.entity.Activity;
import com.itheima.entity.Course;
import com.itheima.vo.PageResult;

import java.util.List;

public interface ActivityService {
    PageResult<Activity> queryPage(ActivityDTO activityDTO);
    void update(Activity activity);
    void add(Activity activity);
    Activity getById(Integer id);

    void deleById(Integer id);

    List<Activity> queryAll();
}
