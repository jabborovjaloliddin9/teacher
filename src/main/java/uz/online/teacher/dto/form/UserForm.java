package uz.online.teacher.dto.form;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import uz.online.teacher.dto.AddressDto;

import java.util.List;

import static uz.online.teacher.constants.ValidationMessages.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
    @NotBlank(message = NOT_NULL_MESSAGE)
    private String firstName;
    @NotBlank(message = NOT_NULL_MESSAGE)
    private String lastName;
    @NotBlank(message = NOT_NULL_MESSAGE)
    private String secondName;
    @NotBlank(message = NOT_NULL_MESSAGE)
    @Pattern(regexp = "[0-9]{4}-[0-9]{2}-[0-9]{2}", message = DATE_PATTERN_NOT_VALID)
    private String birthDate;
    private Integer genderId;
    private String pinfl;
    @NotBlank(message = NOT_NULL_MESSAGE)
    @Pattern(regexp = "[A-Z]{2}", message = PATTERN_NOT_VALID)
    private String documentSerial;
    @NotBlank(message = NOT_NULL_MESSAGE)
    @Pattern(regexp = "[0-9]{7}", message = PATTERN_NOT_VALID)
    private String documentNumber;
    @NotBlank(message = NOT_NULL_MESSAGE)
    private String username;
    @NotBlank(message = NOT_NULL_MESSAGE)
    private String password;
    @Pattern(regexp = "[0-9]{12}", message = PATTERN_NOT_VALID)
    private String phone;
    @Email(message = EMAIL_INCORRECT)
    private String email;
    private String parentFullName;
    @NotBlank(message = NOT_NULL_MESSAGE)
    @Pattern(regexp = "[0-9]{12}", message = PATTERN_NOT_VALID)
    private String parentPhone;
    private Integer authorityId;
    private Integer addressId;
    private AddressForm addressForm;
    private List<Integer> subjectIds;
}
