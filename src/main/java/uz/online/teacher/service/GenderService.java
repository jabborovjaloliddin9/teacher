package uz.online.teacher.service;

import uz.online.teacher.dto.GenderDto;
import uz.online.teacher.dto.ResponseDto;

import java.util.List;

public interface GenderService {

    ResponseDto<GenderDto> getOne(Integer id);

    ResponseDto<List<GenderDto>> findAll();
}
