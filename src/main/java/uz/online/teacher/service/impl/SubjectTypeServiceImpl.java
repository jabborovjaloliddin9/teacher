package uz.online.teacher.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.online.teacher.dto.SubjectTypeDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.form.SubjectTypeForm;
import uz.online.teacher.entity.LocalizedString;
import uz.online.teacher.entity.Subject;
import uz.online.teacher.entity.SubjectType;
import uz.online.teacher.exception.ObjectNotFoundException;
import uz.online.teacher.repository.SubjectRepository;
import uz.online.teacher.repository.SubjectTypeRepository;
import uz.online.teacher.service.SubjectTypeService;

import java.text.ParseException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubjectTypeServiceImpl implements SubjectTypeService {

    private final SubjectTypeRepository repository;
    private final SubjectRepository subjectRepository;

    @PostConstruct
    public void insertInitial() {

    }

    @Override
    public ResponseDto<SubjectTypeDto> getOne(Integer id) {
        return ResponseDto.<SubjectTypeDto>builder()
                .success(true)
                .data(SubjectTypeDto.toDto(get(id)))
                .build();
    }

    @Override
    public ResponseDto<List<SubjectTypeDto>> getAll() {
        return ResponseDto.<List<SubjectTypeDto>>builder()
                .success(true)
                .data(repository.findAllByDeletedFalse().stream().map(SubjectTypeDto::toDto).toList())
                .build();
    }

    @Override
    public ResponseDto<Page<SubjectTypeDto>> getList(Integer page, Integer size) {
        return ResponseDto.<Page<SubjectTypeDto>>builder()
                .success(true)
                .data(repository.findAllByDeletedFalse(PageRequest.of(page, size)).map(SubjectTypeDto::toDto))
                .build();
    }

    @Override
    public ResponseDto<SubjectTypeDto> create(SubjectTypeForm form) throws ParseException {
        return ResponseDto.<SubjectTypeDto>builder()
                .success(true)
                .data(SubjectTypeDto.toDto(repository.save(fill(new SubjectType(), form))))
                .build();
    }

    @Override
    public ResponseDto<SubjectTypeDto> update(Integer id, SubjectTypeForm form) throws ParseException {
        return ResponseDto.<SubjectTypeDto>builder()
                .success(true)
                .data(SubjectTypeDto.toDto(repository.save(fill(get(id), form))))
                .build();
    }

    @Override
    public void delete(Integer id) {
        SubjectType subjectType = get(id);
        subjectType.setDeleted(true);
        repository.save(subjectType);
    }

    public SubjectType fill(SubjectType subjectType, SubjectTypeForm form) throws ParseException {
        subjectType.setName(form.getName());
        return subjectType;
    }

    public SubjectType get(Integer id) {
        return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ObjectNotFoundException(id.toString(), "SubjectType"));
    }
}
