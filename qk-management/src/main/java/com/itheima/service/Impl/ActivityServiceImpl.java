package com.itheima.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dto.ActivityDTO;
import com.itheima.dto.CoursePageDTO;
import com.itheima.entity.Activity;
import com.itheima.entity.Course;
import com.itheima.mapper.ActivityMapper;
import com.itheima.mapper.CoursesMapper;
import com.itheima.service.ActivityService;
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
public class ActivityServiceImpl implements ActivityService {
    private final ActivityMapper activityMapper;

    @Override
    public void add(Activity activity) {
        activity.setCreateTime(LocalDateTime.now());
        activity.setUpdateTime(LocalDateTime.now());
        activityMapper.add(activity);
    }

    @Override
    public Activity getById(Integer id) {
        return activityMapper.getById(id);
    }

    @Override
    public void deleById(Integer id) {
        activityMapper.deleteById(id);
    }

    @Override
    public List<Activity> queryAll() {
        return activityMapper.queryAll();
    }


    @Override
    public void update(Activity activity) {
        activity.setUpdateTime(LocalDateTime.now());
        activityMapper.update(activity);
    }

    @Override
    public PageResult<Activity> queryPage(ActivityDTO activityDTO) {
        PageResult<Activity> pageResult = new PageResult<>();
        PageHelper.startPage(activityDTO.getPage(), activityDTO.getPageSize());
        List<Activity> courses = activityMapper.queryPage(activityDTO);
        Page<Activity> page = (Page<Activity>) courses;
        pageResult.setTotal(page.getTotal());
        pageResult.setRows(page.getResult());
        return pageResult;
    }

}
