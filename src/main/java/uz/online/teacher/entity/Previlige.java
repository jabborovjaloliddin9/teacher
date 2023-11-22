package uz.online.teacher.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Previlige extends BaseEntity {
    @Column(length = 64, unique = true, nullable = false)
    private String previlige;
    @Embedded
    private LocalizedString name;
}
