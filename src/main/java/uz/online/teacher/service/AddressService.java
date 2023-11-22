package uz.online.teacher.service;

import org.springframework.data.domain.Page;
import uz.online.teacher.dto.AddressDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.form.AddressForm;

import java.text.ParseException;
import java.util.List;

public interface AddressService {

    ResponseDto<AddressDto> getOne(Integer id);
    ResponseDto<Page<AddressDto>> getList(Integer page, Integer size);
    ResponseDto<AddressDto> create(AddressForm form) throws ParseException;
    ResponseDto<AddressDto> update(Integer id, AddressForm form) throws ParseException;
    void delete(Integer id);
}
