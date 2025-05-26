package cn.garvy.project.healthservice.pojo.entity;

import lombok.Data;

@Data
public class User {
    private Integer userId;
    private Role role;
    private String name;
    private Gender gender;
    private Integer age;
    private String password;
    private String avatar;
    private String email;

    public enum Role { student, consultant, counsellor }
    public enum Gender { male, female }

}