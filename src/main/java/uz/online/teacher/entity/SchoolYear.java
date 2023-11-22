package uz.online.teacher.entity;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SchoolYear extends BaseEntity {
    private String name;
    private Date startDate;
    private Date endDate;
    private boolean isActive = true;
}
