package uz.online.teacher.dto.form;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import uz.online.teacher.entity.LocalizedString;

import static uz.online.teacher.constants.ValidationMessages.NOT_NULL_MESSAGE;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PreviligeForm {
    @NotBlank(message = NOT_NULL_MESSAGE)
    private String previlige;
    private LocalizedString name;
}
