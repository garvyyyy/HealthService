package cn.garvy.project.healthservice.common;

public enum CodeEnum {
    USER_LOGIN_SUCCESS(20000, "login success"),
    USER_NOT_EXIST(20001, "account number or password is incorrect"),

    USER_EXIST(20002, "email address has been registered"),

    USER_REGISTER_SUCCESS(20003, "register success"),

    EMAIL_NOT_REGISTERED(20004, "email address is not registered"),
    RESET_PASSWORD_SUCCESS(20005, "password was successfully changed"),

    SERVER_ERROR(90000, "server failure");
    private final Integer code;
    private final String message;

    CodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
