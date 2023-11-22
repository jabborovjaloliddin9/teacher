package uz.online.teacher.entity;

import jakarta.persistence.Embeddable;
import lombok.*;
import org.springframework.context.i18n.LocaleContextHolder;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class LocalizedString {
    private String uz;
    private String ru;
    private String en;

    public String locale() {
        return switch (LocaleContextHolder.getLocale().toString()) {
            case "en" -> en;
            case "ru" -> ru;
            default -> uz;
        };
    }
}
