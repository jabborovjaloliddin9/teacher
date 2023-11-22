package uz.online.teacher.exception;

import uz.online.teacher.enums.ErrorCode;

import static uz.online.teacher.enums.ErrorCode.LOGIN_OR_PASSWORD_WRONG;

public class LoginOrPasswordWrongEcception extends GeneralApiException{
    @Override
    ErrorCode errorCode() {
        return LOGIN_OR_PASSWORD_WRONG;
    }
}
