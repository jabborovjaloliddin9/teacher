package uz.online.teacher.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GroupPaymentPrice extends BaseEntity {
    @ManyToOne
    private Group group;
    @ManyToOne
    private Tarif tarif;
    private int price;
}
