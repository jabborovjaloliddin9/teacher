package uz.online.teacher.exception;

import uz.online.teacher.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static uz.online.teacher.enums.ErrorCode.USER_ALLREADY_EXISTS;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAllreadyExistsException extends GeneralApiException {
    public String username;

    @Override
    ErrorCode errorCode() {
        return USER_ALLREADY_EXISTS;
    }
}
