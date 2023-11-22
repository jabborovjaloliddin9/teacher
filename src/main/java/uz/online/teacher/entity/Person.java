//package uz.online.teacher.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.Date;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Entity
//@Table(
//        name = "person",
//        uniqueConstraints = @UniqueConstraint(name = "person_documentSerial_documentNumber", columnNames = {"documentSerial", "documentNumber"}),
//        indexes = @Index(name = "person_gender_index", columnList = "gender_id")
//)
//public class Person extends BaseEntity {
//    @Column(length = 32, nullable = false)
//    private String firstName;
//    @Column(length = 32, nullable = false)
//    private String lastName;
//    @Column(length = 32)
//    private String secondName;
//    @Column(length = 128, nullable = false)
//    private String fullName;
//    private Date birthDate;
//    @ManyToOne
//    @JoinColumn(name = "gender_id", referencedColumnName = "id")
//    private Gender gender;
//    @Column(length = 16, unique = true)
//    private String pinfl;
//    @Column(length = 4)
//    private String documentSerial;
//    @Column(length = 16)
//    private String documentNumber;
//    @Column(length = 64, unique = true)
//    private String phone;
//    @Column(length = 64, unique = true)
//    private String email;
//    @ManyToOne
//    private Address address;
//}
