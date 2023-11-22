package uz.online.teacher.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SubjectType extends BaseEntity {
    private LocalizedString name;
}
