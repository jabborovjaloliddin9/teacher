package uz.online.teacher.service;

import org.springframework.data.domain.Page;
import uz.online.teacher.dto.SubjectTypeDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.form.SubjectTypeForm;

import java.text.ParseException;
import java.util.List;

public interface SubjectTypeService {

    ResponseDto<SubjectTypeDto> getOne(Integer id);
    ResponseDto<List<SubjectTypeDto>> getAll();
    ResponseDto<Page<SubjectTypeDto>> getList(Integer page, Integer size);
    ResponseDto<SubjectTypeDto> create(SubjectTypeForm form) throws ParseException;
    ResponseDto<SubjectTypeDto> update(Integer id, SubjectTypeForm form) throws ParseException;
    void delete(Integer id);
}
