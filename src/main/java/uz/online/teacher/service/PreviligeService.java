package uz.online.teacher.service;

import org.springframework.data.domain.Page;
import uz.online.teacher.dto.PreviligeDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.form.PreviligeForm;

import java.text.ParseException;
import java.util.List;

public interface PreviligeService {

    ResponseDto<PreviligeDto> getOne(Integer id);
    ResponseDto<List<PreviligeDto>> getAll();
    ResponseDto<Page<PreviligeDto>> getList(Integer page, Integer size);
    ResponseDto<PreviligeDto> create(PreviligeForm form) throws ParseException;
    ResponseDto<PreviligeDto> update(Integer id, PreviligeForm form) throws ParseException;
    void delete(Integer id);
}
