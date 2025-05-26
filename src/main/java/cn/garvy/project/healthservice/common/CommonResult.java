package cn.garvy.project.healthservice.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommonResult {
    private Object data;
    private String msg;
    private Integer code;
    public CommonResult(Object data,String msg,Integer code){
        this.data = data;
        this.msg = msg;
        this.code = code;
    }

    public CommonResult SUCCESS(Object data){
        return new CommonResult(data, "login success", 200);
    }

    public CommonResult FAILURE(){
        return new CommonResult(null, "login failure", 201);
    }
}
