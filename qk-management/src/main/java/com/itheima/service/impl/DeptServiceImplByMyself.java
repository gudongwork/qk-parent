package com.itheima.service.impl;

import com.itheima.dto.DeptDTO;
import com.itheima.entity.Dept;
import com.itheima.mapper.DeptMapper;
import com.itheima.service.DeptService;
import com.itheima.vo.PageResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor // 只会给final的成员变量生成构造方法
public class DeptServiceImplByMyself implements DeptService {

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

        //分两条sql
        //第一条sql：查询总条数
        Long total = deptMapper.count(deptDTO);

        deptDTO.setStart((long) ((deptDTO.getPage() - 1) * deptDTO.getPageSize()));

        //第二条sql：查询当前页数据
        List<Dept> rows = deptMapper.selectByPage(deptDTO);

        pageResult.setTotal(total);
        pageResult.setRows(rows);


        return pageResult;
    }
}
