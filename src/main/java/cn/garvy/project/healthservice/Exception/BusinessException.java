package cn.garvy.project.healthservice.Exception;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException{
    private final Integer code;
    public BusinessException(Integer code, String msg){
        super(msg);
        this.code = code;
    }

    public Integer getCode(){
        return code;
    }
}
