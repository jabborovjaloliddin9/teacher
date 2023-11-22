package uz.online.teacher.dto;

import lombok.*;
import uz.online.teacher.entity.District;
import uz.online.teacher.entity.Subject;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectGetAllDto {
    private Integer id;
    private String name;

    public static SubjectGetAllDto toDto(Subject subject) {
        return SubjectGetAllDto.builder()
                .id(subject.getId())
                .name(subject.getName().locale())
                .build();
    }
}
