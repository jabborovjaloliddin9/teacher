package uz.online.teacher.exception;

import uz.online.teacher.dto.ErrorResponse;
import uz.online.teacher.enums.ErrorCode;
import lombok.Getter;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

@Getter
public abstract class GeneralApiException extends RuntimeException{
    abstract ErrorCode errorCode();

    public ErrorResponse response(MessageSource messageSource, Object ... args) {
        return ErrorResponse.of(
                errorCode().getCode(),
                messageSource.getMessage(errorCode().name(), args, LocaleContextHolder.getLocale())
        );
    }
}
