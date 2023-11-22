package uz.online.teacher.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.online.teacher.dto.GenderDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.exception.ObjectNotFoundException;
import uz.online.teacher.repository.GenderRepository;
import uz.online.teacher.service.GenderService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenderServiceImpl implements GenderService {

    private final GenderRepository repository;

    @Override
    public ResponseDto<GenderDto> getOne(Integer id) {
        return ResponseDto.<GenderDto>builder()
                .success(true)
                .data(GenderDto.toDto(repository.findByIdAndDeletedFalse(id)
                        .orElseThrow(()-> new ObjectNotFoundException(id.toString(), "Gender"))))
                .build();
    }

    @Override
    public ResponseDto<List<GenderDto>> findAll() {
        return ResponseDto.<List<GenderDto>>builder()
                .success(true)
                .data(repository.findAllByDeletedFalse().stream().map(GenderDto::toDto).collect(Collectors.toList()))
                .build();
    }
}
