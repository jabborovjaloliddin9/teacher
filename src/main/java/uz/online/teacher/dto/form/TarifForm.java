package uz.online.teacher.dto.form;

import lombok.*;
import uz.online.teacher.entity.LocalizedString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TarifForm {
    private LocalizedString name;
}
