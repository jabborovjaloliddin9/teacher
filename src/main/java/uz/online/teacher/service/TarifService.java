package uz.online.teacher.service;

import org.springframework.data.domain.Page;
import uz.online.teacher.dto.TarifDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.form.TarifForm;

import java.text.ParseException;
import java.util.List;

public interface TarifService {

    ResponseDto<TarifDto> getOne(Integer id);
    ResponseDto<List<TarifDto>> getAll();
    ResponseDto<Page<TarifDto>> getList(Integer page, Integer size);
    ResponseDto<TarifDto> create(TarifForm form) throws ParseException;
    ResponseDto<TarifDto> update(Integer id, TarifForm form) throws ParseException;
    void delete(Integer id);
}
