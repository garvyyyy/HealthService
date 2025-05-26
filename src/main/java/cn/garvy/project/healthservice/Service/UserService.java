package cn.garvy.project.healthservice.Service;

import cn.garvy.project.healthservice.pojo.DTO.UserLoginDTO;
import cn.garvy.project.healthservice.pojo.VO.UserInfoVO;
import cn.garvy.project.healthservice.pojo.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();
    User findUserById(Integer id);

    UserInfoVO login(UserLoginDTO userLoginDTO);

}
