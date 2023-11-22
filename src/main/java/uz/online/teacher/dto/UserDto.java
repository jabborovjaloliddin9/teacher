package uz.online.teacher.dto;

import lombok.*;
import uz.online.teacher.entity.User;
import uz.online.teacher.utils.DateTimeUtils;

import java.util.List;

import static uz.online.teacher.constants.DateTimeConstant.toStringFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String secondName;
    private String fullName;
    private GenderDto genderDto;
    private String birthDate;
    private String pinfl;
    private String documentSerial;
    private String documentNumber;
    private AddressDto addressDto;
    private String phone;
    private String email;
    private String parentFullName;
    private String parentPhone;
    private AuthorityDto authorityDto;
    private List<SubjectDto> subjectDtos;

    public static UserDto toDto(User user) {
        if (user == null)
            return null;
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .secondName(user.getSecondName())
                .fullName(user.getFullName())
                .genderDto(GenderDto.toDto(user.getGender()))
                .birthDate(DateTimeUtils.dataToString(toStringFormat, user.getBirthDate()))
                .pinfl(user.getPinfl())
                .documentSerial(user.getDocumentSerial())
                .documentNumber(user.getDocumentNumber())
                .addressDto(AddressDto.toDto(user.getAddress()))
                .phone(user.getPhone())
                .email(user.getEmail())
                .parentFullName(user.getParentFullName())
                .parentPhone(user.getParentPhone())
                .authorityDto(AuthorityDto.toDto(user.getAuthority()))
                .subjectDtos(user.getSubjects().stream().map(SubjectDto::toDto).toList())
                .build();
    }
}
