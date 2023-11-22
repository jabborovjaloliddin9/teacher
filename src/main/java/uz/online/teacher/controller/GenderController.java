package uz.online.teacher.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.online.teacher.dto.AddressDto;
import uz.online.teacher.dto.GenderDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.service.GenderService;

import java.util.List;

import static uz.online.teacher.constants.swaggerdoc.GenderDoc.GETONE_RESPONSE_BADREQUEST;
import static uz.online.teacher.constants.swaggerdoc.GenderDoc.GETONE_RESPONSE_SUCCESS;

@RestController
@RequestMapping("gender")
@RequiredArgsConstructor
public class GenderController {

    private final GenderService service;

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "lang parametr must be given as requestparam like \"lang=uz\" or \"lang=ru\" or \"lang=en\"",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(name = "success data", value = GETONE_RESPONSE_SUCCESS),
                            schema = @Schema(implementation = ResponseDto.class, subTypes = AddressDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "bad request",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = {
                                    @ExampleObject(name = "exception", value = GETONE_RESPONSE_BADREQUEST)
                            },
                            schema = @Schema(implementation = ResponseDto.class, subTypes = AddressDto.class))
            )
    })
    @GetMapping("{id}")
    public ResponseEntity<ResponseDto<GenderDto>> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getOne(id));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<List<GenderDto>>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
