package uz.online.teacher.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.online.teacher.dto.WeekDayDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.form.WeekDayForm;
import uz.online.teacher.entity.WeekDay;
import uz.online.teacher.exception.ObjectNotFoundException;
import uz.online.teacher.repository.WeekDayRepository;
import uz.online.teacher.service.WeekDayService;

import java.text.ParseException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeekDayServiceImpl implements WeekDayService {

    private final WeekDayRepository repository;

    @Override
    public ResponseDto<WeekDayDto> getOne(Integer id) {
        return ResponseDto.<WeekDayDto>builder()
                .success(true)
                .data(WeekDayDto.toDto(get(id)))
                .build();
    }

    @Override
    public ResponseDto<List<WeekDayDto>> getAll() {
        return ResponseDto.<List<WeekDayDto>>builder()
                .success(true)
                .data(repository.findAllByDeletedFalse().stream().map(WeekDayDto::toDto).toList())
                .build();
    }

    @Override
    public ResponseDto<Page<WeekDayDto>> getList(Integer page, Integer size) {
        return ResponseDto.<Page<WeekDayDto>>builder()
                .success(true)
                .data(repository.findAllByDeletedFalse(PageRequest.of(page, size)).map(WeekDayDto::toDto))
                .build();
    }

    @Override
    public ResponseDto<WeekDayDto> create(WeekDayForm form) throws ParseException {
        return ResponseDto.<WeekDayDto>builder()
                .success(true)
                .data(WeekDayDto.toDto(repository.save(fill(new WeekDay(), form))))
                .build();
    }

    @Override
    public ResponseDto<WeekDayDto> update(Integer id, WeekDayForm form) throws ParseException {
        return ResponseDto.<WeekDayDto>builder()
                .success(true)
                .data(WeekDayDto.toDto(repository.save(fill(get(id), form))))
                .build();
    }

    @Override
    public void delete(Integer id) {
        WeekDay weekDay = get(id);
        weekDay.setDeleted(true);
        repository.save(weekDay);
    }

    public WeekDay fill(WeekDay weekDay, WeekDayForm form) throws ParseException {
        weekDay.setName(form.getName());
        return weekDay;
    }

    public WeekDay get(Integer id) {
        return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ObjectNotFoundException(id.toString(), "WeekDay"));
    }
}
