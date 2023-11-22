package uz.online.teacher.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserContact extends BaseEntity {
    @Column(length = 64, unique = true)
    private String phone;
}
