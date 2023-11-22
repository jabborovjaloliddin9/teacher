package uz.online.teacher.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.online.teacher.dto.AddressDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.form.AddressForm;
import uz.online.teacher.entity.Address;
import uz.online.teacher.exception.ObjectNotFoundException;
import uz.online.teacher.repository.AddressRepository;
import uz.online.teacher.repository.DistrictRepository;
import uz.online.teacher.repository.RegionRepository;
import uz.online.teacher.service.AddressService;

import java.text.ParseException;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;
    private final RegionRepository regionRepository;
    private final DistrictRepository districtRepository;

    @Override
    public ResponseDto<AddressDto> getOne(Integer id) {
        return ResponseDto.<AddressDto>builder()
                .success(true)
                .data(AddressDto.toDto(get(id)))
                .build();
    }

    @Override
    public ResponseDto<Page<AddressDto>> getList(Integer page, Integer size) {
        return ResponseDto.<Page<AddressDto>>builder()
                .success(true)
                .data(repository.findAllByDeletedFalse(PageRequest.of(page, size)).map(AddressDto::toDto))
                .build();
    }

    @Override
    public ResponseDto<AddressDto> create(AddressForm form) throws ParseException {
        return ResponseDto.<AddressDto>builder()
                .success(true)
                .data(AddressDto.toDto(repository.save(fill(new Address(), form))))
                .build();
    }

    @Override
    public ResponseDto<AddressDto> update(Integer id, AddressForm form) throws ParseException {
        return ResponseDto.<AddressDto>builder()
                .success(true)
                .data(AddressDto.toDto(repository.save(fill(get(id), form))))
                .build();
    }

    @Override
    public void delete(Integer id) {
        Address address = get(id);
        address.setDeleted(true);
        repository.save(address);
    }

    public Address fill(Address address, AddressForm form) throws ParseException {
        address.setRegion(regionRepository.findByIdAndDeletedFalse(form.getRegionId())
                .orElseThrow(()-> new ObjectNotFoundException(form.getRegionId().toString(), "region")));
        address.setDistrict(districtRepository.findByIdAndDeletedFalse(form.getDistrictId())
                .orElseThrow(()-> new ObjectNotFoundException(form.getDistrictId().toString(), "district")));
        address.setAddress(form.getAddress());
        return address;
    }

    public Address get(Integer id) {
        return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ObjectNotFoundException(id.toString(), "Address"));
    }
}
