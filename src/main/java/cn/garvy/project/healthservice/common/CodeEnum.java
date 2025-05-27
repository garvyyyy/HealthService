package cn.garvy.project.healthservice.common;

public enum CodeEnum {
    USER_LOGIN_SUCCESS(20000, "login success"),
    USER_NOT_EXIST(20001, "The account number or password is incorrect"),

//    USER_EXIST(20002, "email address has been registered"),

    USER_REGISTER_SUCCESS(20003, "register success"),

    EMAIL_REGISTERED(30001, "The email address is registered"),
    EMAIL_NOT_REGISTERED(30001, "The email address is not registered"),
    EMAIL_SEND_SUCCESS(30003, "The email was sent successfully"),
    RESET_PASSWORD_SUCCESS(1, "The password was successfully changed"),

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
