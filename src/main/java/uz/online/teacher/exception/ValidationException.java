package uz.online.teacher.exception;

import uz.online.teacher.enums.ErrorCode;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ValidationException extends GeneralApiException{
    private String field;
    private String rejectedValue;
    @Override
    ErrorCode errorCode() {
        return null;
    }
}
