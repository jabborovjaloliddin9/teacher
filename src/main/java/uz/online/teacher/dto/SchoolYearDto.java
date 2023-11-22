package uz.online.teacher.dto;

import lombok.*;
import uz.online.teacher.entity.SchoolYear;
import uz.online.teacher.utils.DateTimeUtils;

import static uz.online.teacher.constants.DateTimeConstant.toStringFormat;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolYearDto {
    private Integer id;
    private String name;
    private String startDate;
    private String endDate;

    public static SchoolYearDto toDto(SchoolYear schoolYear) {
        return SchoolYearDto.builder()
                .id(schoolYear.getId())
                .name(schoolYear.getName())
                .startDate(DateTimeUtils.dataToString(toStringFormat, schoolYear.getStartDate()))
                .endDate(DateTimeUtils.dataToString(toStringFormat, schoolYear.getEndDate()))
                .build();
    }
}
