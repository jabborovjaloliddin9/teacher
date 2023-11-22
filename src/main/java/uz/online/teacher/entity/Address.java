package uz.online.teacher.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Address extends BaseEntity {
    @ManyToOne
    private Region region;
    @ManyToOne
    private District district;
    @Column(unique = true, nullable = false)
    private String address;
}
