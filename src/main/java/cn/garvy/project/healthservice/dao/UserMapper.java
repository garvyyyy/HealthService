package cn.garvy.project.healthservice.dao;

import cn.garvy.project.healthservice.pojo.DTO.ResetPasswordDTO;
import cn.garvy.project.healthservice.pojo.DTO.UserLoginDTO;
import cn.garvy.project.healthservice.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAllUser();

    User findUserById(Integer id);

    User findUserByEmailANDPassword(@RequestBody UserLoginDTO userLoginDTO);

    User findUserByEmail(String email);

    boolean insertUser(@Param("email") String email, @Param("password") String password);

    boolean updatePassword(@RequestBody ResetPasswordDTO resetPasswordDTO);
}
