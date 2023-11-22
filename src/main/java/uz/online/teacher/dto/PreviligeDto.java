package uz.online.teacher.dto;

import lombok.*;
import uz.online.teacher.entity.Previlige;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PreviligeDto {
    private Integer id;
    private String previlige;
    private String name;

    public static PreviligeDto toDto(Previlige previlige) {
        if(previlige == null)
            return null;
        return PreviligeDto.builder()
                .id(previlige.getId())
                .previlige(previlige.getPrevilige())
                .name(previlige.getName().locale())
                .build();
    }
}
