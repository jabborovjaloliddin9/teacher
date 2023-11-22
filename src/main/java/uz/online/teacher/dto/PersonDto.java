//package uz.online.teacher.dto;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import lombok.*;
//import uz.online.teacher.entity.Address;
//import uz.online.teacher.entity.Gender;
//import uz.online.teacher.entity.Person;
//import uz.online.teacher.entity.User;
//import uz.online.teacher.utils.DateTimeUtils;
//
//import java.util.Date;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class PersonDto {
//    private Integer id;
//    private String firstName;
//    private String lastName;
//    private String secondName;
//    private String fullName;
//    private GenderDto genderDto;
//    private String birthDate;
//    private String pinfl;
//    private String documentSerial;
//    private String documentNumber;
//    private String phone;
//    private String email;
//    private AddressDto addressDto;
//
//    public static PersonDto toDto(Person person) {
//        return PersonDto.builder()
//                .id(person.getId())
//                .firstName(person.getFirstName())
//                .lastName(person.getLastName())
//                .secondName(person.getSecondName())
//                .fullName(person.getFullName())
//                .genderDto(GenderDto.toDto(person.getGender()))
//                .birthDate(DateTimeUtils.toString("yyyy-MM-dd", person.getBirthDate()))
//                .pinfl(person.getPinfl())
//                .documentSerial(person.getDocumentSerial())
//                .documentNumber(person.getDocumentNumber())
//                .phone(person.getPhone())
//                .email(person.getEmail())
//                .addressDto(AddressDto.toDto(person.getAddress()))
//                .build();
//    }
//}
