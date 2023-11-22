package uz.online.teacher.controller;

import jakarta.validation.UnexpectedTypeException;
import uz.online.teacher.dto.ErrorDto;
import uz.online.teacher.dto.ErrorResponse;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

import static uz.online.teacher.enums.ErrorCode.ACCESS_DENIED_EXCEPTION;

@ControllerAdvice
@RequiredArgsConstructor
public class HandleException {

    private final MessageSource messageSource;

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseDto<Object>> handleException(RuntimeException e) {

        ResponseDto<Object> dto = new ResponseDto<>();
        dto.setSuccess(false);
        dto.setCode(2);
        dto.setMessage("");
        dto.setData(null);

        if (e instanceof ObjectNotFoundException exception) {
            dto.setErrorResponse(exception.response(messageSource, exception.getObjectName(), exception.getId()));
            return ResponseEntity.badRequest().body(dto);
        }

        if (e instanceof DatabaseException exception) {
            dto.setErrorResponse(exception.response(messageSource, exception.getMessage()));
            return ResponseEntity.badRequest().body(dto);
        }

        if(e instanceof UserAllreadyExistsException exception) {
            dto.setErrorResponse(exception.response(messageSource, exception.getUsername()));
            return ResponseEntity.badRequest().body(dto);
        }

        if (e instanceof LoginOrPasswordWrongEcception exception) {
            dto.setErrorResponse(exception.response(messageSource));
            return ResponseEntity.badRequest().body(dto);
        }

        if (e instanceof RoleNotGivenException exception) {
            dto.setErrorResponse(exception.response(messageSource));
            return ResponseEntity.badRequest().body(dto);
        }

        if (e instanceof ObjectAllreadyExistsException exception) {
            ErrorResponse response = exception.response(messageSource, exception.getObjectName(), exception.getField());
            dto.setErrorResponse(response);
            return ResponseEntity.badRequest().body(dto);
        }

//        if(e instanceof AccessDeniedException exception) {
//            dto.setErrorResponse(ErrorResponse.of(
//                    ACCESS_DENIED_EXCEPTION.getCode(),
//                    messageSource.getMessage(ACCESS_DENIED_EXCEPTION.name(), null, LocaleContextHolder.getLocale())));
//            return ResponseEntity.badRequest().body(dto);
//        }
//
//        if (e instanceof UnexpectedTypeException exception) {
//            ErrorResponse response = exception.response(messageSource, exception.getObjectName(), exception.getField());
//            dto.setErrorResponse(response);
//            return ResponseEntity.badRequest().body(dto);
//        }

        dto.setErrorResponse(ErrorResponse.of(
                111,
                e.getMessage()
        ));

        return ResponseEntity.badRequest().body(dto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto<Object>> getError(MethodArgumentNotValidException e) {
        ResourceBundleMessageSource messageSource1 = new ResourceBundleMessageSource();
        messageSource1.setBasename("i18n/messages");
        messageSource1.setDefaultEncoding("UTF-8");
        List<ErrorDto> errors = e.getBindingResult().getFieldErrors().stream().map(it -> {
            String field = it.getField();
            String message = it.getDefaultMessage();
            String rejectedValue = String.valueOf(it.getRejectedValue());
            assert message != null;
            String returnMessage = messageSource1.getMessage(message, new String[]{field, rejectedValue}, LocaleContextHolder.getLocale());
            return new ErrorDto(field, returnMessage);
        }).collect(Collectors.toList());

        ResponseDto<Object> dto = new ResponseDto<>();
        dto.setCode(1);
        dto.setSuccess(false);
        dto.setMessage("Validation error");
        dto.setErrors(errors);
        return ResponseEntity.badRequest().body(dto);
    }
}

