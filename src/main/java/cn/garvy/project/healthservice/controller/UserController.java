package cn.garvy.project.healthservice.controller;

import cn.garvy.project.healthservice.Service.UserService;
import cn.garvy.project.healthservice.common.CommonResult;
import cn.garvy.project.healthservice.pojo.DTO.UserLoginDTO;
import cn.garvy.project.healthservice.pojo.VO.UserInfoVO;
import cn.garvy.project.healthservice.pojo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @PostMapping("/login")
    public CommonResult login(@RequestBody UserLoginDTO userLoginDTO){
        UserInfoVO userInfoVO = userService.login(userLoginDTO);
        if(userInfoVO == null) return new CommonResult().FAILURE();
        return new CommonResult().SUCCESS(userInfoVO);
    }
}
