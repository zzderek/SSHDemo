package com.derek.controller;

import com.derek.model.User;
import com.derek.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "restful", description = "接口测试")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "根据id查询用户信息")
    @GetMapping("/getuser")
    public User getUser(Integer id){
        return userService.getUserById(id);
    }

    @ApiOperation(value = "保存用户信息")
    @PostMapping("/user")
    public void getUser(@RequestBody User user){
         userService.saveUser(user);
    }
}
