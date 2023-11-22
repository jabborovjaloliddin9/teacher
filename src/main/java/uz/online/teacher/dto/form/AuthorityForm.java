package uz.online.teacher.dto.form;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import uz.online.teacher.entity.LocalizedString;
import static uz.online.teacher.constants.ValidationMessages.NOT_NULL_MESSAGE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityForm {
    @NotBlank(message = NOT_NULL_MESSAGE)
    private String authority;
    private LocalizedString name;
}
