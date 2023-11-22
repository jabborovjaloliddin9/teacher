package uz.online.teacher.dto;

import lombok.*;
import uz.online.teacher.entity.District;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistrictGetAllDto {
    private Integer id;
    private String name;

    public static DistrictGetAllDto toDto(District district) {
        return DistrictGetAllDto.builder()
                .id(district.getId())
                .name(district.getName().locale())
                .build();
    }
}
