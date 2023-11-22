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
public class GroupStudent extends BaseEntity {
    private User student;
    private Date startDate;
    private Date endDate;
    private boolean isActive = true;
}