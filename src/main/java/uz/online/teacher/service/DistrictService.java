package uz.online.teacher.service;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;
import uz.online.teacher.dto.DistrictDto;
import uz.online.teacher.dto.DistrictGetAllDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.form.DistrictForm;

import java.text.ParseException;
import java.util.List;

public interface DistrictService {

    ResponseDto<DistrictDto> getOne(Integer id);
    ResponseDto<List<DistrictGetAllDto>> getAll(int regionId);
    ResponseDto<Page<DistrictDto>> getList(int regionId, Integer page, Integer size);
    ResponseDto<DistrictDto> create(DistrictForm form) throws ParseException;
    ResponseDto<DistrictDto> update(Integer id, DistrictForm form) throws ParseException;
    void delete(Integer id);
}
