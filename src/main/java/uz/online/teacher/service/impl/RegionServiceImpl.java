package uz.online.teacher.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.RegionDto;
import uz.online.teacher.dto.form.RegionForm;
import uz.online.teacher.entity.LocalizedString;
import uz.online.teacher.entity.Region;
import uz.online.teacher.exception.ObjectNotFoundException;
import uz.online.teacher.repository.RegionRepository;
import uz.online.teacher.service.RegionService;

import java.text.ParseException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionRepository repository;

    @Override
    public ResponseDto<RegionDto> getOne(Integer id) {
        return ResponseDto.<RegionDto>builder()
                .success(true)
                .data(RegionDto.toDto(get(id)))
                .build();
    }

    @Override
    public ResponseDto<List<RegionDto>> getAll() {
        return ResponseDto.<List<RegionDto>>builder()
                .success(true)
                .data(repository.findAllByDeletedFalse().stream().map(RegionDto::toDto).toList())
                .build();
    }

    @Override
    public ResponseDto<Page<RegionDto>> getList(Integer page, Integer size) {
        return ResponseDto.<Page<RegionDto>>builder()
                .success(true)
                .data(repository.findAllByDeletedFalse(PageRequest.of(page, size)).map(RegionDto::toDto))
                .build();
    }

    @Override
    public ResponseDto<RegionDto> create(RegionForm form) throws ParseException {
        return ResponseDto.<RegionDto>builder()
                .success(true)
                .data(RegionDto.toDto(repository.save(fill(new Region(), form))))
                .build();
    }

    @Override
    public ResponseDto<RegionDto> update(Integer id, RegionForm form) throws ParseException {
        return ResponseDto.<RegionDto>builder()
                .success(true)
                .data(RegionDto.toDto(repository.save(fill(get(id), form))))
                .build();
    }

    @Override
    public void delete(Integer id) {
        Region region = get(id);
        region.setDeleted(true);
        repository.save(region);
    }

    public Region fill(Region region, RegionForm form) throws ParseException {
        region.setName(form.getName());
        return region;
    }

    public Region get(Integer id) {
        return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ObjectNotFoundException(id.toString(), "Region"));
    }
}
