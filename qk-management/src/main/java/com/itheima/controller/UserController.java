package com.itheima.controller;

import com.itheima.dto.UserDTO;
import com.itheima.entity.User;
import com.itheima.service.UserService;
import com.itheima.vo.PageResult;
import com.itheima.vo.Result;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Data
@RequiredArgsConstructor
@RestController()
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @GetMapping
    public Result queryByPage(UserDTO userDTO){
        PageResult<User> pageData =  userService.queryByPage(userDTO);
        return Result.success(pageData);
    }
    @PutMapping
    public Result update(@RequestBody User user){
        userService.update(user);
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody User user){
        userService.add(user);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result queryById(@PathVariable Integer id){
        User user = userService.queryById(id);
        return Result.success(user);
    }
    @GetMapping("/role/{roleLabel}")
    public Result queryByRoleLabel(@PathVariable String roleLabel){
        return Result.success(userService.queryByRoleLabel(roleLabel));
    }
    @GetMapping("/list")
    public Result queryAll(){
        return Result.success(userService.queryAll());
    }
    @GetMapping("/dept/{deptId}")
    public Result queryByDeptId(@PathVariable String deptId){
        return Result.success(userService.queryByDeptId(deptId));
    }
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        userService.delete(ids);
        return Result.success();
    }
}
