package uz.online.teacher.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "users")
@Table(
        name = "users",
        uniqueConstraints = @UniqueConstraint(name = "user_documentSerial_documentNumber", columnNames = {"documentSerial", "documentNumber"}),
        indexes = @Index(name = "user_gender_index", columnList = "gender_id")
)
public class User extends BaseEntity {
    @Column(length = 32, nullable = false)
    private String firstName;
    @Column(length = 32, nullable = false)
    private String lastName;
    @Column(length = 32)
    private String secondName;
    @Column(length = 128, nullable = false)
    private String fullName;
    private Date birthDate;
    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    private Gender gender;
    @Column(length = 16, unique = true)
    private String pinfl;
    @Column(length = 4)
    private String documentSerial;
    @Column(length = 16)
    private String documentNumber;
    @Column(length = 64, unique = true)
    private String phone;
    @Column(length = 64, unique = true)
    private String email;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;
    @Column(length = 128)
    private String parentFullName;
    @Column(length = 64, unique = true)
    private String parentPhone;
    //for auth
    @Column(length = 64, unique = true, nullable = false)
    private String username;
    private String password;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Authority authority;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "user_subject",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"))
    private List<Subject> subjects;
}
