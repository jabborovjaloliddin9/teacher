package uz.online.teacher.dto;

import lombok.*;
import uz.online.teacher.entity.Region;
import uz.online.teacher.entity.SubjectType;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectTypeDto implements Serializable {
    private Integer id;
    private String name;

    public static SubjectTypeDto toDto(SubjectType subjectType) {
        if(subjectType == null)
            return null;
        return SubjectTypeDto.builder()
                .id(subjectType.getId())
                .name(subjectType.getName().locale())
                .build();
    }
}
