package uz.online.teacher.dto;

import lombok.*;
import uz.online.teacher.entity.District;
import uz.online.teacher.entity.Subject;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectDto {
    private Integer id;
    private String name;
    private SubjectTypeDto subjectTypeDto;

    public static SubjectDto toDto(Subject subject) {
        if (subject == null)
            return null;
        return SubjectDto.builder()
                .id(subject.getId())
                .name(subject.getName().locale())
                .subjectTypeDto(SubjectTypeDto.toDto(subject.getSubjectType()))
                .build();
    }
}
