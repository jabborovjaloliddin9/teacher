package uz.online.teacher.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.online.teacher.dto.SubjectDto;
import uz.online.teacher.dto.SubjectGetAllDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.form.SubjectForm;
import uz.online.teacher.service.SubjectService;

import java.text.ParseException;
import java.util.List;

import static uz.online.teacher.constants.swaggerdoc.SubjectDoc.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("subject")
public class SubjectController {

    private final SubjectService service;

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "lang parametr must be given as requestparam like \"lang=uz\" or \"lang=ru\" or \"lang=en\"",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(name = "success data", value = GETONE_RESPONSE_SUCCESS),
                            schema = @Schema(implementation = ResponseDto.class, subTypes = SubjectDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "bad request",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = {
                                    @ExampleObject(name = "exception", value = GETONE_RESPONSE_BADREQUEST)
                            },
                            schema = @Schema(implementation = ResponseDto.class, subTypes = SubjectDto.class))
            )
    })
    @GetMapping("{id}")
    public ResponseEntity<ResponseDto<SubjectDto>> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getOne(id));
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples =  {
                                    @ExampleObject(name = "success data", value = GETDALL_RESPONSE_SUCCESS),
                                    @ExampleObject(name = "success data empty", value = GETALL_RESPONSE_SUCCESS_EMPTY)
                            },
                            schema = @Schema(implementation = ResponseDto.class, subTypes = SubjectDto.class))
            )
    })
    @GetMapping("all")
    public ResponseEntity<ResponseDto<List<SubjectGetAllDto>>> getAll(@RequestParam int subjectTypeId) {
        return ResponseEntity.ok(service.getAll(subjectTypeId));
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples =  {
                                    @ExampleObject(name = "success data", value = GETDLIST_RESPONSE_SUCCESS),
                                    @ExampleObject(name = "success data empty", value = GETLIST_RESPONSE_SUCCESS_EMPTY)
                            },
                            schema = @Schema(implementation = ResponseDto.class, subTypes = SubjectDto.class))
            )
    })
    @GetMapping("list")
    public ResponseEntity<ResponseDto<Page<SubjectDto>>> getList(@RequestParam int subjectTypeId, @RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(service.getList(subjectTypeId, page, size));
    }
    @Operation(
            description = "Update new Subject",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Request object example",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = {
                                    @ExampleObject(value = CREATE_EXAMPLE)
                            })
            )
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(name = "success data", value = CREATE_RESPONSE_SUCCESS),
                            schema = @Schema(implementation = ResponseDto.class, subTypes = SubjectDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "bad request",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = {
                                    @ExampleObject(name = "exception", value = CREATE_RESPONSE_BADREQUEST)
                            },
                            schema = @Schema(implementation = ResponseDto.class, subTypes = SubjectDto.class))
            )
    })
    @PostMapping
    public ResponseEntity<ResponseDto<SubjectDto>> create(@RequestBody @Valid SubjectForm form) throws ParseException {
        return ResponseEntity.ok(service.create(form));
    }

    @Operation(
            description = "lang parametr must be given as requestparam like \"lang=uz\" or \"lang=ru\" or \"lang=en\"",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Request object example",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = {
                                    @ExampleObject(value = CREATE_EXAMPLE)
                            })
            )
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "lang parametr must be given as requestparam like \"lang=uz\" or \"lang=ru\" or \"lang=en\"",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(name = "success data", value = UPDATE_RESPONSE_SUCCESS),
                            schema = @Schema(implementation = ResponseDto.class, subTypes = SubjectDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "bad request",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = {
                                    @ExampleObject(name = "exception", value = UPDATE_RESPONSE_BADREQUEST)
                            },
                            schema = @Schema(implementation = ResponseDto.class, subTypes = SubjectDto.class))
            )
    })
    @PutMapping("{id}")
    public ResponseEntity<ResponseDto<SubjectDto>> update(@PathVariable Integer id, @RequestBody @Valid SubjectForm form) throws ParseException {
        return ResponseEntity.ok(service.update(id, form));
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "bad request",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = {
                                    @ExampleObject(name = "exception", value = DELETE_RESPONSE_BADREQUEST)
                            },
                            schema = @Schema(implementation = ResponseDto.class, subTypes = SubjectDto.class))
            )
    })
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
