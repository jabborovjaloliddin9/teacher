package uz.online.teacher.dto.form;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolYearForm {
    private String name;
    private String startDate;
    private String endDate;
}
