package uz.online.teacher.dto;

import lombok.*;
import uz.online.teacher.entity.Gender;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenderDto {
    private Integer id;
    private String name;

    public static GenderDto toDto(Gender gender) {
        if(gender == null)
            return null;
        return GenderDto.builder()
                .id(gender.getId())
                .name(gender.getName().locale())
                .build();
    }
}
