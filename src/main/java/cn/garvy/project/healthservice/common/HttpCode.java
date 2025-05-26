package cn.garvy.project.healthservice.common;

public enum HttpCode {

    SUCCESS(200, "请求成功"),
    BAD_REQUEST(400, "请求参数有误"),
    UNAUTHORIZED(401, "未授权或登录失效"),
    FORBIDDEN(403, "没有权限访问"),
    NOT_FOUND(404, "资源不存在"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误");

    private final int code;
    private final String message;

    HttpCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
