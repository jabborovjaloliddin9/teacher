package uz.online.teacher.dto;

import lombok.*;
import uz.online.teacher.entity.UserContact;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserContactDto {
    private Integer id;
    private String phone;

    public static UserContactDto toDto(UserContact contact) {
        if(contact == null)
            return null;
        return UserContactDto.builder()
                .id(contact.getId())
                .phone(contact.getPhone())
                .build();
    }
}
