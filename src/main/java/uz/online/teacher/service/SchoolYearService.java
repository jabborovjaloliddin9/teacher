package uz.online.teacher.service;

import org.springframework.data.domain.Page;
import uz.online.teacher.dto.SchoolYearDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.form.SchoolYearForm;

import java.text.ParseException;
import java.util.List;

public interface SchoolYearService {

    ResponseDto<SchoolYearDto> getOne(Integer id);
    ResponseDto<List<SchoolYearDto>> getAll();
    ResponseDto<Page<SchoolYearDto>> getList(Integer page, Integer size);
    ResponseDto<SchoolYearDto> create(SchoolYearForm form) throws ParseException;
    ResponseDto<SchoolYearDto> update(Integer id, SchoolYearForm form) throws ParseException;
    void delete(Integer id);
}
