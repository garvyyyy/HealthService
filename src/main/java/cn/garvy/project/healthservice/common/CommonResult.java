package cn.garvy.project.healthservice.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public CommonResult(T data){
        this.data = data;
    }

    public static <T> CommonResult<T> success(CodeEnum codeEnum, T data){
        CommonResult result = new CommonResult(codeEnum.getCode(),codeEnum.getMessage(), data);
        return result;
    }
}
