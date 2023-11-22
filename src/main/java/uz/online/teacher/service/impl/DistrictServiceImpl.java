package uz.online.teacher.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.online.teacher.dto.DistrictDto;
import uz.online.teacher.dto.DistrictGetAllDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.form.DistrictForm;
import uz.online.teacher.entity.District;
import uz.online.teacher.exception.ObjectNotFoundException;
import uz.online.teacher.repository.DistrictRepository;
import uz.online.teacher.repository.RegionRepository;
import uz.online.teacher.service.DistrictService;

import java.text.ParseException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository repository;
    private final RegionRepository regionRepository;

    @Override
    public ResponseDto<DistrictDto> getOne(Integer id) {
        return ResponseDto.<DistrictDto>builder()
                .success(true)
                .data(DistrictDto.toDto(get(id)))
                .build();
    }

    @Override
    public ResponseDto<List<DistrictGetAllDto>> getAll(int regionId) {
        return ResponseDto.<List<DistrictGetAllDto>>builder()
                .success(true)
                .data(repository.findRegionDistrict(regionId).stream().map(DistrictGetAllDto::toDto).toList())
                .build();
    }
    @Override
    public ResponseDto<Page<DistrictDto>> getList(int regionId, Integer page, Integer size) {
        return ResponseDto.<Page<DistrictDto>>builder()
                .success(true)
                .data(repository.findRegionDistrictPaged(regionId, PageRequest.of(page, size)).map(DistrictDto::toDto))
                .build();
    }
    @Override
    public ResponseDto<DistrictDto> create(DistrictForm form) throws ParseException {
        return ResponseDto.<DistrictDto>builder()
                .success(true)
                .data(DistrictDto.toDto(repository.save(fill(new District(), form))))
                .build();
    }

    @Override
    public ResponseDto<DistrictDto> update(Integer id, DistrictForm form) throws ParseException {
        return ResponseDto.<DistrictDto>builder()
                .success(true)
                .data(DistrictDto.toDto(repository.save(fill(get(id), form))))
                .build();
    }

    @Override
    public void delete(Integer id) {
        District district = get(id);
        district.setDeleted(true);
        repository.save(district);
    }

    public District fill(District district, DistrictForm form) throws ParseException {
        district.setName(form.getName());
        district.setRegion(regionRepository.findByIdAndDeletedFalse(form.getRegionId())
                .orElseThrow(()-> new ObjectNotFoundException(form.getRegionId().toString(), "region")));
        return district;
    }

    public District get(Integer id) {
        return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ObjectNotFoundException(id.toString(), "District"));
    }
}
