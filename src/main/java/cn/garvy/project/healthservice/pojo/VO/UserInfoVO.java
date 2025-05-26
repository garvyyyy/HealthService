package cn.garvy.project.healthservice.pojo.VO;

import cn.garvy.project.healthservice.pojo.entity.User;
import lombok.Data;

@Data
public class UserInfoVO {
    private User.Role role;
    private String name;
    private User.Gender gender;
    private Integer age;
    private String avatar;
    private String email;

    public enum Role { student, consultant, counsellor }
    public enum Gender { male, female }
}
