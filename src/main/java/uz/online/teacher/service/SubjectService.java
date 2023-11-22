package uz.online.teacher.service;

import org.springframework.data.domain.Page;
import uz.online.teacher.dto.SubjectDto;
import uz.online.teacher.dto.SubjectGetAllDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.form.SubjectForm;

import java.text.ParseException;
import java.util.List;

public interface SubjectService {

    ResponseDto<SubjectDto> getOne(Integer id);
    ResponseDto<List<SubjectGetAllDto>> getAll(int subjectTypeId);
    ResponseDto<Page<SubjectDto>> getList(int subjectTypeId, Integer page, Integer size);
    ResponseDto<SubjectDto> create(SubjectForm form) throws ParseException;
    ResponseDto<SubjectDto> update(Integer id, SubjectForm form) throws ParseException;
    void delete(Integer id);
}
