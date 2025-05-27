package cn.garvy.project.healthservice.Service.Impl;

import java.lang.String;
import cn.garvy.project.healthservice.Service.EmailService;
import cn.garvy.project.healthservice.utils.CaptchaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Service
public class EmailServiceImpl implements EmailService {
    @Resource
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    private static final String CODE_PREFIX = "Captcha:";
    private static final long CODE_EXPIRE_TIME = 60;

    @Override
    public void saveCaptcha(String email, String captcha){
        String key = CODE_PREFIX + email;
        redisTemplate.opsForValue().set(key, captcha, CODE_EXPIRE_TIME, TimeUnit.SECONDS);
    }
    @Override
    public void sendCaptcha(String toEmail) {
        String captcha = CaptchaUtils.generateCaptcha();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(toEmail);
        message.setSubject("RegisterCaptcha");
        message.setText(captcha);
        mailSender.send(message);

        //保存验证码到redis
        saveCaptcha(toEmail,captcha);
//        System.out.println("---------------------------");
        System.out.println("captcha: \n" + captcha);
//        System.out.println("---------------------------");
//        System.out.println("captcha: " + redisTemplate.opsForValue().get(CODE_PREFIX + toEmail));
    }


    @Override
    public boolean verifyCaptcha(String email, String captcha) {
        String key = CODE_PREFIX + email;
        String saveCaptcha = redisTemplate.opsForValue().get(key);
//        System.out.println("---------------------------");
//        System.out.println(saveCaptcha);
//        System.out.println("---------------------------");
//        System.out.println(captcha);
        if(saveCaptcha != null && saveCaptcha.equals(captcha)){
            redisTemplate.delete(key);
            return true;
        }
        return false;
    }

}
