package uz.online.teacher.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.*;
import uz.online.teacher.entity.Address;
import uz.online.teacher.entity.District;
import uz.online.teacher.entity.Region;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {
    private Integer id;
    private RegionDto regionDto;
    private DistrictDto districtDto;
    private String address;

    public static AddressDto toDto(Address address) {
        if(address == null)
            return null;
        return AddressDto.builder()
                .id(address.getId())
                .regionDto(RegionDto.toDto(address.getRegion()))
                .districtDto(DistrictDto.toDto(address.getDistrict()))
                .address(address.getAddress())
                .build();
    }
}
