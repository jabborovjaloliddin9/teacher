package uz.online.teacher.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "authorities")
public class Authority extends BaseEntity {
    @Column(length = 64, unique = true, nullable = false)
    private String authority;
    @Embedded
    private LocalizedString name;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "authority_previlige",
            joinColumns = @JoinColumn(name = "authority_id"),
            inverseJoinColumns = @JoinColumn(name = "previlige_id"))
    private List<Previlige> previliges;
}
