package com.itheima.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dto.ActivityDTO;
import com.itheima.entity.Activity;
import com.itheima.mapper.ActivityMapper;
import com.itheima.service.ActivityService;
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

        //开始分页
        //给当前线程绑定了一个Page对象（page,pageSize）
        PageResult<Activity> pageResult = new PageResult<>();
        //正常的查询不要limit
        //当mybatis去生成sql的时候，获取当前线程对象，然后从当前线程中获取mp对象，从map中取分页参数
        //1. 没有获取到分页参数，正常执行当前的查询
        //2. 获取到了分页参数（从当前线程中移除参数，保证一个分页参数只能用一次）
        //2.1 动态去执行一个统计查询 select count(0) from activity where 1=1 and status=1
        //2.2 动态去执行一个查询 select * from activity where 1=1 and status=1 limit 0,10
        PageHelper.startPage(activityDTO.getPage(), activityDTO.getPageSize());
        List<Activity> courses = activityMapper.queryPage(activityDTO);
        //考虑到返回的list对象，本质是一个Page对象，page对象是ArrayList的子类，但是里面提供了total属性
        Page<Activity> page = (Page<Activity>) courses;
        pageResult.setTotal(page.getTotal());
        pageResult.setRows(page.getResult());
        return pageResult;
    }

}
