package com.itheima.mapper;

import com.itheima.dto.ActivityDTO;
import com.itheima.entity.Activity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ActivityMapper {
    List<Activity> queryPage(ActivityDTO activityDTO);
    void update(Activity activity);
    @Update("insert into activity (channel, name, start_time, end_time, description, type,discount,voucher) values (#{channel}, #{name}, #{startTime}, #{endTime}, #{description}, #{type},#{discount},#{voucher})")
    void add(Activity activity);
    @Select("select * from activity where id = #{id}")
    Activity getById(Integer id);
    @Delete("delete from activity where id = #{id}")
    void deleteById(Integer id);
    @Select("select * from activity")
    List<Activity> queryAll();
}
