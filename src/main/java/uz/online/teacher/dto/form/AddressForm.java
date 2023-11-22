package uz.online.teacher.dto.form;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressForm {
    private Integer regionId;
    private Integer districtId;
    private String address;
}
