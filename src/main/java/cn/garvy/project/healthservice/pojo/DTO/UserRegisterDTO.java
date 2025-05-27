package cn.garvy.project.healthservice.pojo.DTO;

import lombok.Data;

@Data
public class UserRegisterDTO {
    private String email;
    private String captcha;
    private String password;
    private String confirmPassword;
}
