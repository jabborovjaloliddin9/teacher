package uz.online.teacher.dto;

import jakarta.persistence.Entity;
import lombok.*;
import uz.online.teacher.constants.DateTimeConstant;
import uz.online.teacher.entity.Group;
import uz.online.teacher.entity.SchoolYear;
import uz.online.teacher.entity.Subject;
import uz.online.teacher.entity.User;
import uz.online.teacher.utils.DateTimeUtils;

import java.time.Instant;

import static uz.online.teacher.constants.DateTimeConstant.toStringFormat;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto {
    private Integer id;
    private String name;
    private Integer orderNumber;
    private SubjectDto subjectDto;
    private String startDate;
    private String endDate;
    private UserDto teacherDto;
    private SchoolYearDto schoolYearDto;
    private boolean isActive;

    public static GroupDto toDto(Group group) {
        return GroupDto.builder()
                .id(group.getId())
                .name(group.getName())
                .orderNumber(group.getOrderNumber())
                .subjectDto(SubjectDto.toDto(group.getSubject()))
                .startDate(DateTimeUtils.dataToString(toStringFormat, group.getStartDate()))
                .endDate(DateTimeUtils.dataToString(toStringFormat, group.getEndDate()))
                .teacherDto(UserDto.toDto(group.getTeacher()))
                .schoolYearDto(SchoolYearDto.toDto(group.getSchoolYear()))
                .isActive(group.isActive())
                .build();
    }
}
