package uz.online.teacher.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subject extends BaseEntity {
    private LocalizedString name;
    @ManyToOne
    private SubjectType subjectType;
    @ManyToMany(mappedBy = "subjects")
    public List<User> users;
}
