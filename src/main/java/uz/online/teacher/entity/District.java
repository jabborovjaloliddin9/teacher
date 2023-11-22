package uz.online.teacher.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class District extends BaseEntity {
    @Embedded
    private LocalizedString name;
    @ManyToOne
    private Region region;
}
