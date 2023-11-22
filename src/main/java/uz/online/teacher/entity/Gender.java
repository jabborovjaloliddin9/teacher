package uz.online.teacher.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Gender extends BaseEntity {
    @Embedded
    private LocalizedString name;
}
