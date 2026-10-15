package com.itheima.controller;

import com.itheima.dto.RoleDTO;
import com.itheima.entity.Role;
import com.itheima.service.RoleService;
import com.itheima.vo.PageResult;
import com.itheima.vo.Result;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    public Result findByDTO(RoleDTO roleDTO){
        log.info("roleDTO: {}", roleDTO);
        PageResult<Role> pageResult = roleService.findByDTO(roleDTO);
        return Result.success(pageResult);
    }

    @PutMapping
    public Result update(@RequestBody Role role){
        log.info("role: {}", role);
        roleService.updateById(role);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Role role){
        log.info("role: {}", role);
        roleService.add(role);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("id: {}", id);
        Role role = roleService.findById(id);
        return Result.success(role);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        log.info("id: {}", id);
        roleService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/list")
    public Result findAll(){
        log.info("查询所有");
        List<Role> roleList = roleService.findAll();
        return Result.success(roleList);
    }

}
