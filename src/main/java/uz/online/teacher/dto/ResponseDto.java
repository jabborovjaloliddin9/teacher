package uz.online.teacher.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {
    private boolean success;
    private String message;
    /**
     * 0-success
     * 1-validation error
     * 2-exception
     * 3-database error
     * */
    private int code;
    private List<ErrorDto> errors;
    private ErrorResponse errorResponse;
    private T data;
}
