package cn.garvy.project.healthservice.Service.Impl;

import cn.garvy.project.healthservice.Enum.Status;
import cn.garvy.project.healthservice.Exception.BusinessException;
import cn.garvy.project.healthservice.Service.UserService;
import cn.garvy.project.healthservice.dao.UserMapper;
import cn.garvy.project.healthservice.pojo.DTO.UserLoginDTO;
import cn.garvy.project.healthservice.pojo.VO.UserInfoVO;
import cn.garvy.project.healthservice.pojo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public UserInfoVO login(UserLoginDTO userLoginDTO) {
        User user = userMapper.findUserByNameANDPassword(userLoginDTO.getName(), userLoginDTO.getPassword());
        if(user == null){
            throw new BusinessException(401, "账号或密码错误");
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setRole(user.getRole());
        userInfoVO.setName(user.getName());
        userInfoVO.setGender(user.getGender());
        userInfoVO.setAge(user.getAge());
        userInfoVO.setAvatar(user.getAvatar());
        userInfoVO.setEmail(user.getEmail());
        return userInfoVO;
    }
}
