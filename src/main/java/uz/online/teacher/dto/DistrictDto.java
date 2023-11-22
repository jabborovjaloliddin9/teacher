package uz.online.teacher.dto;

import lombok.*;
import uz.online.teacher.entity.District;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DistrictDto {
    private Integer id;
    private String name;
    private RegionDto regionDto;

    public static DistrictDto toDto(District district) {
        if (district == null)
            return null;
        return DistrictDto.builder()
                .id(district.getId())
                .name(district.getName().locale())
                .regionDto(RegionDto.toDto(district.getRegion()))
                .build();
    }
}
