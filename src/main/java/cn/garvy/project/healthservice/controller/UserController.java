package cn.garvy.project.healthservice.controller;

import cn.garvy.project.healthservice.Service.UserService;
import cn.garvy.project.healthservice.common.CodeEnum;
import cn.garvy.project.healthservice.common.CommonResult;
import cn.garvy.project.healthservice.pojo.DTO.ResetPasswordDTO;
import cn.garvy.project.healthservice.pojo.DTO.UserLoginDTO;
import cn.garvy.project.healthservice.pojo.DTO.UserRegisterDTO;
import cn.garvy.project.healthservice.pojo.VO.UserInfoVO;
import cn.garvy.project.healthservice.pojo.entity.User;
import cn.garvy.project.healthservice.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @PostMapping("/login")
    public ResponseEntity<CommonResult<UserInfoVO>> login(@RequestBody UserLoginDTO userLoginDTO){
        UserInfoVO userInfoVO = userService.login(userLoginDTO);
        CommonResult<UserInfoVO> result = CommonResult.success(CodeEnum.USER_LOGIN_SUCCESS,userInfoVO);
        return ResultUtils.SUCCESS(result);
    }

    @PostMapping("/register")
    public ResponseEntity<CommonResult> register(@RequestBody UserRegisterDTO userRegisterDTO){
        boolean success = userService.register(userRegisterDTO);
        CommonResult result = CommonResult.success(CodeEnum.USER_REGISTER_SUCCESS,null);
        return ResultUtils.SUCCESS(result);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<CommonResult> resetPassword(@RequestBody ResetPasswordDTO resetPasswordDTO){
        boolean success = userService.resetPassword(resetPasswordDTO);
        CommonResult result = CommonResult.success(CodeEnum.RESET_PASSWORD_SUCCESS,null);
        return ResultUtils.SUCCESS(result);
    }
}
