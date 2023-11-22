package uz.online.teacher.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.online.teacher.dto.WeekDayDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.service.WeekDayService;

import java.util.List;

import static uz.online.teacher.constants.swaggerdoc.WeekDayDoc.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("week-day")
public class WeekDayController {

    private final WeekDayService service;

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "lang parametr must be given as requestparam like \"lang=uz\" or \"lang=ru\" or \"lang=en\"",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(name = "success data", value = GETONE_RESPONSE_SUCCESS),
                            schema = @Schema(implementation = ResponseDto.class, subTypes = WeekDayDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "bad request",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = {
                                    @ExampleObject(name = "exception", value = GETONE_RESPONSE_BADREQUEST)
                            },
                            schema = @Schema(implementation = ResponseDto.class, subTypes = WeekDayDto.class))
            )
    })
    @GetMapping("{id}")
    public ResponseEntity<ResponseDto<WeekDayDto>> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getOne(id));
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples =  {
                                    @ExampleObject(name = "success data", value = GETALL_RESPONSE_SUCCESS),
                                    @ExampleObject(name = "success data empty", value = GETALL_RESPONSE_SUCCESS_EMPTY)
                            },
                            schema = @Schema(implementation = ResponseDto.class, subTypes = WeekDayDto.class))
            )
    })
    @GetMapping("all")
    public ResponseEntity<ResponseDto<List<WeekDayDto>>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
