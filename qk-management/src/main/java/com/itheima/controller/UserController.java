package com.itheima.controller;

import com.itheima.dto.UserDTO;
import com.itheima.entity.User;
import com.itheima.service.Impl.UserServiceImpl;
import com.itheima.service.UserService;
import com.itheima.vo.PageResult;
import com.itheima.vo.Result;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.*;


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
}
