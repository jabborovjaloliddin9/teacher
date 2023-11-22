package uz.online.teacher.exception;

import uz.online.teacher.enums.ErrorCode;

import static uz.online.teacher.enums.ErrorCode.ROLE_NOT_GIVEN;

public class RoleNotGivenException extends GeneralApiException{
    @Override
    ErrorCode errorCode() {
        return ROLE_NOT_GIVEN;
    }
}
