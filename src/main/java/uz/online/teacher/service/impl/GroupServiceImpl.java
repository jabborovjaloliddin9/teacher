package uz.online.teacher.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import uz.online.teacher.constants.DateTimeConstant;
import uz.online.teacher.dto.GroupDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.form.GroupForm;
import uz.online.teacher.entity.Group;
import uz.online.teacher.exception.ObjectNotFoundException;
import uz.online.teacher.repository.GroupRepository;
import uz.online.teacher.repository.SchoolYearRepository;
import uz.online.teacher.repository.SubjectRepository;
import uz.online.teacher.repository.UserRepository;
import uz.online.teacher.service.GroupService;
import uz.online.teacher.utils.DateTimeUtils;
import uz.online.teacher.utils.UserUtils;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static uz.online.teacher.constants.DateTimeConstant.toDateFormat;

@Slf4j
@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository repository;
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;
    private final SchoolYearRepository schoolYearRepository;

    @Override
    public ResponseDto<GroupDto> getOne(Integer id) {
        return ResponseDto.<GroupDto>builder()
                .success(true)
                .data(GroupDto.toDto(get(id)))
                .build();
    }

    @Override
    public ResponseDto<List<GroupDto>> getAll() {
        return ResponseDto.<List<GroupDto>>builder()
                .success(true)
                .data(repository.findAllByDeletedFalse().stream().map(GroupDto::toDto).toList())
                .build();
    }

    @Override
    public ResponseDto<Page<GroupDto>> getList(Integer page, Integer size) {
        return ResponseDto.<Page<GroupDto>>builder()
                .success(true)
                .data(repository.findAllByDeletedFalse(PageRequest.of(page, size)).map(GroupDto::toDto))
                .build();
    }

    @Override
    public ResponseDto<GroupDto> create(GroupForm form) throws ParseException {
        return ResponseDto.<GroupDto>builder()
                .success(true)
                .data(GroupDto.toDto(repository.save(fill(new Group(), form))))
                .build();
    }

    @Override
    public ResponseDto<GroupDto> update(Integer id, GroupForm form) throws ParseException {
        return ResponseDto.<GroupDto>builder()
                .success(true)
                .data(GroupDto.toDto(repository.save(fill(get(id), form))))
                .build();
    }

    @Override
    public void delete(Integer id) {
        Group group = get(id);
        group.setDeleted(true);
        repository.save(group);
    }

    public Group fill(Group group, GroupForm form) throws ParseException {

        group.setName(form.getName());

        group.setOrderNumber(form.getOrderNumber());

        if (StringUtils.isEmpty(form.getStartDate()))
            group.setStartDate(Date.from(Instant.now()));
        else
            group.setStartDate(DateTimeUtils.toDate(toDateFormat, form.getStartDate()));

        group.setEndDate(DateTimeUtils.toDate(toDateFormat, form.getEndDate()));

        group.setSubject(subjectRepository.findByIdAndDeletedFalse(form.getSubjectId())
                .orElseThrow(() -> new ObjectNotFoundException(form.getSubjectId().toString(), "Subject")));

        if (UserUtils.isTeacher()) {
            group.setTeacher(UserUtils.getCurrentUser());
        } else if (UserUtils.isOrganization()) {
            if (form.getTeacherId() != 0) {
                group.setTeacher(userRepository.findByIdAndDeletedFalse(form.getTeacherId())
                        .orElseThrow(() -> new ObjectNotFoundException(form.getTeacherId().toString(), "Teacher")));
            }
        }

        group.setSchoolYear(schoolYearRepository.getCurrentSchoolYear()
                .orElseThrow(() -> new ObjectNotFoundException("current", "SchoolYear")));

        group.setName(form.getName());

        group.setActive(form.isActive());

        return group;
    }

    public Group get(Integer id) {
        return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ObjectNotFoundException(id.toString(), "Group"));
    }
}
