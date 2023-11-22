package uz.online.teacher.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import uz.online.teacher.dto.SchoolYearDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.form.SchoolYearForm;
import uz.online.teacher.entity.SchoolYear;
import uz.online.teacher.exception.ObjectNotFoundException;
import uz.online.teacher.repository.SchoolYearRepository;
import uz.online.teacher.service.SchoolYearService;
import uz.online.teacher.utils.DateTimeUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import static uz.online.teacher.constants.DateTimeConstant.toDateFormat;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchoolYearServiceImpl implements SchoolYearService {

    private final SchoolYearRepository repository;

    @Scheduled(cron = "0 0 0 1 9 *")
    public void change() throws ParseException {
        SchoolYear schoolYear = repository.getCurrentSchoolYear().orElseThrow(() -> new RuntimeException("Active school year not found!"));
        schoolYear.setActive(false);
        repository.save(schoolYear);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        repository.save(SchoolYear.builder()
                .name(currentYear + "-" + (currentYear + 1))
                .startDate(DateTimeUtils.toDate(toDateFormat, currentYear + "-09-02"))
                .endDate(DateTimeUtils.toDate(toDateFormat, (currentYear + 1) + "-31-08"))
                .isActive(true)
                .build());
        log.info("School year is save!");
    }

    @Override
    public ResponseDto<SchoolYearDto> getOne(Integer id) {
        return ResponseDto.<SchoolYearDto>builder()
                .success(true)
                .data(SchoolYearDto.toDto(get(id)))
                .build();
    }

    @Override
    public ResponseDto<List<SchoolYearDto>> getAll() {
        return ResponseDto.<List<SchoolYearDto>>builder()
                .success(true)
                .data(repository.findAllByDeletedFalse().stream().map(SchoolYearDto::toDto).toList())
                .build();
    }

    @Override
    public ResponseDto<Page<SchoolYearDto>> getList(Integer page, Integer size) {
        return ResponseDto.<Page<SchoolYearDto>>builder()
                .success(true)
                .data(repository.findAllByDeletedFalse(PageRequest.of(page, size)).map(SchoolYearDto::toDto))
                .build();
    }

    @Override
    public ResponseDto<SchoolYearDto> create(SchoolYearForm form) throws ParseException {
        return ResponseDto.<SchoolYearDto>builder()
                .success(true)
                .data(SchoolYearDto.toDto(repository.save(fill(new SchoolYear(), form))))
                .build();
    }

    @Override
    public ResponseDto<SchoolYearDto> update(Integer id, SchoolYearForm form) throws ParseException {
        return ResponseDto.<SchoolYearDto>builder()
                .success(true)
                .data(SchoolYearDto.toDto(repository.save(fill(get(id), form))))
                .build();
    }

    @Override
    public void delete(Integer id) {
        SchoolYear schoolYear = get(id);
        schoolYear.setDeleted(true);
        repository.save(schoolYear);
    }

    public SchoolYear fill(SchoolYear schoolYear, SchoolYearForm form) throws ParseException {
        schoolYear.setName(form.getName());
        schoolYear.setStartDate(DateTimeUtils.toDate(toDateFormat, form.getStartDate()));
        schoolYear.setEndDate(DateTimeUtils.toDate(toDateFormat, form.getEndDate()));
        return schoolYear;
    }

    public SchoolYear get(Integer id) {
        return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ObjectNotFoundException(id.toString(), "SchoolYear"));
    }
}
