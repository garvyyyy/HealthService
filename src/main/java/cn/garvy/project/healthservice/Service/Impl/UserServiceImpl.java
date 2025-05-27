package cn.garvy.project.healthservice.Service.Impl;

import cn.garvy.project.healthservice.Exception.BusinessException;
import cn.garvy.project.healthservice.Service.UserService;
import cn.garvy.project.healthservice.common.CodeEnum;
import cn.garvy.project.healthservice.dao.UserMapper;
import cn.garvy.project.healthservice.pojo.DTO.ResetPasswordDTO;
import cn.garvy.project.healthservice.pojo.DTO.UserLoginDTO;
import cn.garvy.project.healthservice.pojo.DTO.UserRegisterDTO;
import cn.garvy.project.healthservice.pojo.VO.UserInfoVO;
import cn.garvy.project.healthservice.pojo.entity.User;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
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
        User user = userMapper.findUserByEmailANDPassword(userLoginDTO);
        if(user == null){
            throw new BusinessException(CodeEnum.USER_NOT_EXIST);
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

    public boolean isNotRegistered(String email){
        User user = userMapper.findUserByEmail(email);
        if(user != null){
            throw new BusinessException(CodeEnum.EMAIL_REGISTERED);
        }
        return true;
    }

    @Override
    public boolean register(UserRegisterDTO userRegisterDTO) {
        User user = userMapper.findUserByEmail(userRegisterDTO.getEmail());
        if(user != null){
            throw new BusinessException(CodeEnum.EMAIL_REGISTERED);
        }

        boolean success = userMapper.insertUser(userRegisterDTO.getEmail(), userRegisterDTO.getPassword());
        if(! success){
            throw new BusinessException(CodeEnum.SERVER_ERROR);
        }
        return true;
    }

    public boolean resetPassword(ResetPasswordDTO resetPasswordDTO){
        User user = userMapper.findUserByEmail(resetPasswordDTO.getEmail());
        if(user == null){
            throw new BusinessException(CodeEnum.EMAIL_NOT_REGISTERED);
        }
        boolean success = userMapper.updatePassword(resetPasswordDTO);
        if(! success){
            throw new BusinessException(CodeEnum.SERVER_ERROR);
        }
        return true;
    }
}
