package uz.online.teacher.exception;

import uz.online.teacher.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DatabaseException extends GeneralApiException{
    private String message;

    @Override
    ErrorCode errorCode() {
        return ErrorCode.DATABASE_ERROR;
    }
}
