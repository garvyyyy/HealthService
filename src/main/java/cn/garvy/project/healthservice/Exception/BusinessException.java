package cn.garvy.project.healthservice.Exception;

import cn.garvy.project.healthservice.common.CodeEnum;
import lombok.Data;

@Data
public class BusinessException extends RuntimeException{
    private final Integer code;
    public BusinessException(CodeEnum codeEnum){
        super(codeEnum.getMessage());
        this.code = codeEnum.getCode();
    }

    public Integer getCode(){
        return code;
    }
}
