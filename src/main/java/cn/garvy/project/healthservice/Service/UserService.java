package cn.garvy.project.healthservice.Service;

import cn.garvy.project.healthservice.pojo.DTO.ResetPasswordDTO;
import cn.garvy.project.healthservice.pojo.DTO.UserLoginDTO;
import cn.garvy.project.healthservice.pojo.DTO.UserRegisterDTO;
import cn.garvy.project.healthservice.pojo.VO.UserInfoVO;
import cn.garvy.project.healthservice.pojo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> findAllUser();
    User findUserById(Integer id);

    UserInfoVO login(UserLoginDTO userLoginDTO);
    boolean isNotRegistered(String email);

    boolean register(UserRegisterDTO userRegisterDTO);

    boolean resetPassword(ResetPasswordDTO resetPasswordDTO);

}
