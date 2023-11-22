package uz.online.teacher.service;

import org.springframework.data.domain.Page;
import uz.online.teacher.dto.WeekDayDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.form.WeekDayForm;

import java.text.ParseException;
import java.util.List;

public interface WeekDayService {

    ResponseDto<WeekDayDto> getOne(Integer id);
    ResponseDto<List<WeekDayDto>> getAll();
    ResponseDto<Page<WeekDayDto>> getList(Integer page, Integer size);
    ResponseDto<WeekDayDto> create(WeekDayForm form) throws ParseException;
    ResponseDto<WeekDayDto> update(Integer id, WeekDayForm form) throws ParseException;
    void delete(Integer id);
}
