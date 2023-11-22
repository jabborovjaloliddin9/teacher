package uz.online.teacher.dto;

import lombok.*;
import uz.online.teacher.entity.Region;
import uz.online.teacher.entity.WeekDay;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeekDayDto implements Serializable {
    private Integer id;
    private String name;

    public static WeekDayDto toDto(WeekDay weekDay) {
        if(weekDay == null)
            return null;
        return WeekDayDto.builder()
                .id(weekDay.getId())
                .name(weekDay.getName().locale())
                .build();
    }
}
