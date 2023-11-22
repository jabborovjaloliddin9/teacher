package uz.online.teacher.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.online.teacher.dto.SubjectDto;
import uz.online.teacher.dto.SubjectGetAllDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.form.SubjectForm;
import uz.online.teacher.entity.LocalizedString;
import uz.online.teacher.entity.Subject;
import uz.online.teacher.entity.Subject;
import uz.online.teacher.entity.SubjectType;
import uz.online.teacher.exception.ObjectNotFoundException;
import uz.online.teacher.repository.SubjectRepository;
import uz.online.teacher.repository.SubjectTypeRepository;
import uz.online.teacher.service.SubjectService;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository repository;
    private final SubjectTypeRepository subjectTypeRepository;

    @Override
    public ResponseDto<SubjectDto> getOne(Integer id) {
        return ResponseDto.<SubjectDto>builder()
                .success(true)
                .data(SubjectDto.toDto(get(id)))
                .build();
    }

    @Override
    public ResponseDto<List<SubjectGetAllDto>> getAll(int subjectTypeId) {
        return ResponseDto.<List<SubjectGetAllDto>>builder()
                .success(true)
                .data(repository.findSubjectSubjectType(subjectTypeId).stream().map(SubjectGetAllDto::toDto).toList())
                .build();
    }
    @Override
    public ResponseDto<Page<SubjectDto>> getList(int subjectTypeId, Integer page, Integer size) {
        return ResponseDto.<Page<SubjectDto>>builder()
                .success(true)
                .data(repository.findSubjectSubjectType(subjectTypeId, PageRequest.of(page, size)).map(SubjectDto::toDto))
                .build();
    }
    @Override
    public ResponseDto<SubjectDto> create(SubjectForm form) throws ParseException {
        return ResponseDto.<SubjectDto>builder()
                .success(true)
                .data(SubjectDto.toDto(repository.save(fill(new Subject(), form))))
                .build();
    }

    @Override
    public ResponseDto<SubjectDto> update(Integer id, SubjectForm form) throws ParseException {
        return ResponseDto.<SubjectDto>builder()
                .success(true)
                .data(SubjectDto.toDto(repository.save(fill(get(id), form))))
                .build();
    }

    @Override
    public void delete(Integer id) {
        Subject subject = get(id);
        subject.setDeleted(true);
        repository.save(subject);
    }

    public Subject fill(Subject subject, SubjectForm form) throws ParseException {
        subject.setName(form.getName());
        subject.setSubjectType(subjectTypeRepository.findByIdAndDeletedFalse(form.getSubjectId())
                .orElseThrow(()-> new ObjectNotFoundException(form.getSubjectId().toString(), "Subject")));
        return subject;
    }

    public Subject get(Integer id) {
        return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ObjectNotFoundException(id.toString(), "Subject"));
    }
}
