package cn.garvy.project.healthservice.utils;

import cn.garvy.project.healthservice.common.CommonResult;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

public class ResultUtils {

    public static <T> ResponseEntity<T> SUCCESS(T result){
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
