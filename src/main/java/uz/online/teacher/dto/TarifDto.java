package uz.online.teacher.dto;

import lombok.*;
import uz.online.teacher.entity.Region;
import uz.online.teacher.entity.Tarif;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TarifDto implements Serializable {
    private Integer id;
    private String name;

    public static TarifDto toDto(Tarif tarif) {
        if(tarif == null)
            return null;
        return TarifDto.builder()
                .id(tarif.getId())
                .name(tarif.getName().locale())
                .build();
    }
}
