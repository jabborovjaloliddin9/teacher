package uz.online.teacher.service;

import org.springframework.data.domain.Page;
import uz.online.teacher.dto.UserDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.form.UserForm;

import java.text.ParseException;

public interface UserService {

    ResponseDto<UserDto> getOne(Integer id);
    ResponseDto<Page<UserDto>> getList(Integer page, Integer size);
    ResponseDto<UserDto> create(UserForm form) throws ParseException;
    ResponseDto<UserDto> update(Integer id, UserForm form) throws ParseException;
    void delete(Integer id);
}
