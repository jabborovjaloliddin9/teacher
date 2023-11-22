package uz.online.teacher.exception;

import uz.online.teacher.enums.ErrorCode;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObjectNotFoundException extends GeneralApiException{
    private String id;
    private String objectName;

    @Override
    ErrorCode errorCode() {
        return ErrorCode.OBJECT_NOT_FOUND;
    }
}
