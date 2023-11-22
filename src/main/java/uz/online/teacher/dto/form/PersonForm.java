//package uz.online.teacher.dto.form;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Pattern;
//import lombok.*;
//import uz.online.teacher.entity.Address;
//import uz.online.teacher.entity.Gender;
//
//import java.util.Date;
//
//import static uz.online.teacher.enums.Messages.*;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class PersonForm {
//    @NotBlank(message = NOT_NULL_MESSAGE)
//    private String firstName;
//    @NotBlank(message = NOT_NULL_MESSAGE)
//    private String lastName;
//    @NotBlank(message = NOT_NULL_MESSAGE)
//    private String secondName;
//    @NotBlank(message = NOT_NULL_MESSAGE)
//    @Pattern(regexp = "[0-9]{4}-[0-9]{2}-[0-9]{2}", message = DATE_PATTERN_NOT_VALID)
//    private String birthDate;
//    private Integer genderId;
//    private String pinfl;
//    @NotBlank(message = NOT_NULL_MESSAGE)
//    @Pattern(regexp = "[A-Z]{2}", message = PATTERN_NOT_VALID)
//    private String documentSerial;
//    @NotBlank(message = NOT_NULL_MESSAGE)
//    @Pattern(regexp = "[0-9]{7}", message = PATTERN_NOT_VALID)
//    private String documentNumber;
//    @NotBlank(message = NOT_NULL_MESSAGE)
//    @Pattern(regexp = "[0-9]{12}", message = PATTERN_NOT_VALID)
//    private String phone;
//    @Email(message = EMAIL_INCORRECT)
//    @NotBlank(message = NOT_NULL_MESSAGE)
//    private String email;
//    @NotBlank(message = NOT_NULL_MESSAGE)
//    private String username;
//    @NotBlank(message = NOT_NULL_MESSAGE)
//    private String password;
//    private Integer addressId;
//}
