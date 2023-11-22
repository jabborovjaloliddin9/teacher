package uz.online.teacher.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {

    OBJECT_NOT_FOUND(1000),
    DATABASE_ERROR(1001),
    VALIDATION_ERROR(1002),
    USER_ALLREADY_EXISTS(1003),
    LOGIN_OR_PASSWORD_WRONG(1004),
    ROLE_NOT_GIVEN(1005),
    OBJECT_ALLREADY_EXISTS(1007),
    ACCESS_DENIED_EXCEPTION(1008),

    ;

    private int code;
    ErrorCode(int code) {
        this.code = code;
    }
}
