package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dto.DeptDTO;
import com.itheima.entity.Dept;
import com.itheima.mapper.DeptMapper;
import com.itheima.service.DeptService;
import com.itheima.vo.PageResult;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor // 只会给final的成员变量生成构造方法
@Primary
public class DeptServiceImpl implements DeptService {

    //注入DeptMapper对象
    private final DeptMapper deptMapper;
    //添加部门
    @Override
    public void add(Dept dept) {
        //手动填充字段
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public void update(Dept dept) {
        //手动补充字段
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.updateById(dept);
    }

    @Override
    public Dept findById(Integer id) {
        return deptMapper.selectById(id);
    }

    @Override
    public List<Dept> findAll() {
        return deptMapper.selectAll();
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    //分页查询
    @Override
    public PageResult<Dept> findByDTO(DeptDTO deptDTO) {

        PageResult<Dept> pageResult = new PageResult<>();

        //开始分页
        PageHelper.startPage(deptDTO.getPage(),deptDTO.getPageSize());
        //尽管正常按照条件查询
        List<Dept> deptList = deptMapper.selectByDTO(deptDTO);

        System.out.println(deptList);

        //将deptList强转成Page<Dept>对象（Page是PageHelper框架中的类，实现了List接口）
        Page<Dept> page = (Page<Dept>) deptList;
        //将Page中的数据获取出来
        pageResult.setTotal(page.getTotal());
        pageResult.setRows(page.getResult());


        return pageResult;
    }
}
