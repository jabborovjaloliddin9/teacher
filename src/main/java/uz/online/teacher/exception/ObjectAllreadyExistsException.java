package uz.online.teacher.exception;

import uz.online.teacher.enums.ErrorCode;
import lombok.*;

import static uz.online.teacher.enums.ErrorCode.OBJECT_ALLREADY_EXISTS;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObjectAllreadyExistsException extends GeneralApiException{
    private String field;
    private String objectName;
    @Override
    ErrorCode errorCode() {
        return OBJECT_ALLREADY_EXISTS;
    }
}
