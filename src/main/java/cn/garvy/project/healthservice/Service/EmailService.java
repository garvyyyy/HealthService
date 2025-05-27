package cn.garvy.project.healthservice.Service;

import java.lang.String;
import org.springframework.stereotype.Service;

public interface EmailService {
    void saveCaptcha(String email, String captcha);

    void sendCaptcha(String toEmail);
    boolean verifyCaptcha(String email, String captcha);

}
