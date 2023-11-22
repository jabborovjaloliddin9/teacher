package uz.online.teacher.service;

import org.springframework.data.domain.Page;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.RegionDto;
import uz.online.teacher.dto.form.RegionForm;

import java.text.ParseException;
import java.util.List;

public interface RegionService {

    ResponseDto<RegionDto> getOne(Integer id);
    ResponseDto<List<RegionDto>> getAll();
    ResponseDto<Page<RegionDto>> getList(Integer page, Integer size);
    ResponseDto<RegionDto> create(RegionForm form) throws ParseException;
    ResponseDto<RegionDto> update(Integer id, RegionForm form) throws ParseException;
    void delete(Integer id);
}
