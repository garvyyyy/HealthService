package cn.garvy.project.healthservice.Exception;

import cn.garvy.project.healthservice.common.CommonResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<CommonResult> handleBusinessException(BusinessException ex) {
        ErrorResponse error = new ErrorResponse(ex.getCode(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CommonResult());
    }
}
