package cn.garvy.project.healthservice.pojo.DTO;

import lombok.Data;

@Data
public class ResetPasswordDTO {
    private String email;
    private String password;
}
