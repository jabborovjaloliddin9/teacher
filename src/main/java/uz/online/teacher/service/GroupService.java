package uz.online.teacher.service;

import org.springframework.data.domain.Page;
import uz.online.teacher.dto.GroupDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.form.GroupForm;

import java.text.ParseException;
import java.util.List;

public interface GroupService {

    ResponseDto<GroupDto> getOne(Integer id);
    ResponseDto<List<GroupDto>> getAll();
    ResponseDto<Page<GroupDto>> getList(Integer page, Integer size);
    ResponseDto<GroupDto> create(GroupForm form) throws ParseException;
    ResponseDto<GroupDto> update(Integer id, GroupForm form) throws ParseException;
    void delete(Integer id);
}
