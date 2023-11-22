package uz.online.teacher.dto.form;

import lombok.*;
import uz.online.teacher.dto.SchoolYearDto;
import uz.online.teacher.dto.SubjectDto;
import uz.online.teacher.dto.UserDto;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupForm {
    private String name;
    private Integer orderNumber;
    private Integer subjectId;
    private String startDate;
    private String endDate;
    private Integer teacherId;
    private boolean isActive;
    private List<Integer> ids;
}
