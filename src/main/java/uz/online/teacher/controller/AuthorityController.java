package uz.online.teacher.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.online.teacher.dto.AuthorityDto;
import uz.online.teacher.dto.AuthorityGetAllDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.TokenResponseDto;
import uz.online.teacher.dto.form.AuthorityForm;
import uz.online.teacher.dto.form.LoginForm;
import uz.online.teacher.service.AuthorityService;

import java.text.ParseException;
import java.util.List;

import static uz.online.teacher.constants.swaggerdoc.AuthorityDoc.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("authority")
public class AuthorityController {

    private final AuthorityService service;

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "lang parametr must be given as requestparam like \"lang=uz\" or \"lang=ru\" or \"lang=en\"",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(name = "success data", value = GETONE_RESPONSE_SUCCESS),
                            schema = @Schema(implementation = ResponseDto.class, subTypes = AuthorityDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "bad request",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = {
                                    @ExampleObject(name = "exception", value = GETONE_RESPONSE_BADREQUEST)
                            },
                            schema = @Schema(implementation = ResponseDto.class, subTypes = AuthorityDto.class))
            )
    })
    @GetMapping("{id}")
    public ResponseEntity<ResponseDto<AuthorityDto>> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getOne(id));
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples =  {
                                    @ExampleObject(name = "success data", value = FINDALL_RESPONSE_SUCCESS),
                                    @ExampleObject(name = "success data empty", value = FINDALL_RESPONSE_SUCCESS_EMPTY)
                            },
                            schema = @Schema(implementation = ResponseDto.class, subTypes = AuthorityDto.class))
            )
    })
    @GetMapping("all")
    public ResponseEntity<ResponseDto<List<AuthorityGetAllDto>>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples =  {
                                    @ExampleObject(name = "success data", value = GETLIST_RESPONSE_SUCCESS),
                                    @ExampleObject(name = "success data empty", value = GETLIST_RESPONSE_SUCCESS_EMPTY)
                            },
                            schema = @Schema(implementation = ResponseDto.class, subTypes = AuthorityDto.class))
            )
    })
    @GetMapping("list")
    public ResponseEntity<ResponseDto<Page<AuthorityDto>>> getList(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(service.getList(page, size));
    }

    @Operation(
            description = "Update new Authority",
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
                            schema = @Schema(implementation = ResponseDto.class, subTypes = AuthorityDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "bad request",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = {
                                    @ExampleObject(name = "exception", value = CREATE_RESPONSE_BADREQUEST)
                            },
                            schema = @Schema(implementation = ResponseDto.class, subTypes = AuthorityDto.class))
            )
    })
    @PostMapping
    public ResponseEntity<ResponseDto<AuthorityDto>> create(@RequestBody @Valid AuthorityForm form) throws ParseException {
        return ResponseEntity.ok(service.create(form));
    }

    @Operation(
            description = "lang parametr must be given as requestparam like \"lang=uz\" or \"lang=ru\" or \"lang=en\"",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Request object example",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = {
                                    @ExampleObject(value = UPDATE_EXAMPLE)
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
                            schema = @Schema(implementation = ResponseDto.class, subTypes = AuthorityDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "bad request",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = {
                                    @ExampleObject(name = "exception", value = UPDATE_RESPONSE_BADREQUEST)
                            },
                            schema = @Schema(implementation = ResponseDto.class, subTypes = AuthorityDto.class))
            )
    })
    @PutMapping("{id}")
    public ResponseEntity<ResponseDto<AuthorityDto>> update(@PathVariable Integer id, @RequestBody @Valid AuthorityForm form) throws ParseException {
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
                            schema = @Schema(implementation = ResponseDto.class, subTypes = AuthorityDto.class))
            )
    })
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }


    @Operation(
            description = "Sing in",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Request object example",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = { @ExampleObject(value = SIGN_IN_EXAMPLE) })
            )
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "success",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(name = "success data", value = SIGN_IN_RESPONSE_SUCCESS),
                            schema = @Schema(implementation = ResponseDto.class, subTypes = AuthorityDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "bad request",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = { @ExampleObject(name = "exception", value = SIGN_IN_RESPONSE_BAD_REQUEST) },
                            schema = @Schema(implementation = ResponseDto.class, subTypes = AuthorityDto.class))
            )
    })
    @PostMapping("sign-in")
    public ResponseEntity<ResponseDto<TokenResponseDto>> signIn(@RequestBody LoginForm form, HttpServletResponse response) {
        return ResponseEntity.ok(service.signIn(form, response));
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "success",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(name = "success data", value = REFRESH_TOKEN_RESPONSE_SUCCESS),
                            schema = @Schema(implementation = ResponseDto.class, subTypes = AuthorityDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "bad request",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = { @ExampleObject(name = "exception", value = REFRESH_TOKEN_RESPONSE_BAD_REQUEST) },
                            schema = @Schema(implementation = ResponseDto.class, subTypes = AuthorityDto.class))
            )
    })
    @PostMapping("refresh-token")
    public ResponseEntity<ResponseDto<TokenResponseDto>> refreshToken(@RequestParam String refreshToken, HttpServletResponse response) throws Exception {
        return ResponseEntity.ok(service.refreshToken(refreshToken, response));
    }

    @PostMapping("password-reset-send-email")
    public ResponseEntity<ResponseDto<String>> sendEmailForResetPassword(@RequestParam String email, HttpServletRequest request) {
        return ResponseEntity.ok(service.sendEmailForResetPassword(email, request.getSession().getId()));
    }

    @PostMapping("password-reset-send-code")
    public ResponseEntity<ResponseDto<String>> sendCode(String code, HttpServletRequest request) {
        return ResponseEntity.ok(service.sendCode(code, request.getSession().getId()));
    }

}
