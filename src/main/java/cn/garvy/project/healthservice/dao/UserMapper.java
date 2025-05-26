package cn.garvy.project.healthservice.dao;

import cn.garvy.project.healthservice.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAllUser();

    User findUserById(Integer id);

    User findUserByNameANDPassword(@Param("username") String username, @Param("password") String password);

    User findUserByEmail(String email);

    boolean insertUser(String email, String password);
}
