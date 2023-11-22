package uz.online.teacher.dto;

import lombok.*;
import uz.online.teacher.entity.Region;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegionDto implements Serializable {
    private Integer id;
    private String name;

    public static RegionDto toDto(Region region) {
        if(region == null)
            return null;
        return RegionDto.builder()
                .id(region.getId())
                .name(region.getName().locale())
                .build();
    }
}
