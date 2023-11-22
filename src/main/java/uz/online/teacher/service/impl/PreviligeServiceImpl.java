package uz.online.teacher.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.online.teacher.dto.PreviligeDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.form.PreviligeForm;
import uz.online.teacher.entity.Previlige;
import uz.online.teacher.exception.ObjectNotFoundException;
import uz.online.teacher.repository.PreviligeRepository;
import uz.online.teacher.service.PreviligeService;

import java.text.ParseException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PreviligeServiceImpl implements PreviligeService {

    private final PreviligeRepository repository;

    @Override
    public ResponseDto<PreviligeDto> getOne(Integer id) {
        return ResponseDto.<PreviligeDto>builder()
                .success(true)
                .data(PreviligeDto.toDto(get(id)))
                .build();
    }

    @Override
    public ResponseDto<List<PreviligeDto>> getAll() {
        return ResponseDto.<List<PreviligeDto>>builder()
                .success(true)
                .data(repository.findAllByDeletedFalse().stream().map(PreviligeDto::toDto).toList())
                .build();
    }

    @Override
    public ResponseDto<Page<PreviligeDto>> getList(Integer page, Integer size) {
        return ResponseDto.<Page<PreviligeDto>>builder()
                .success(true)
                .data(repository.findAllByDeletedFalse(PageRequest.of(page, size)).map(PreviligeDto::toDto))
                .build();
    }
    @Override
    public ResponseDto<PreviligeDto> create(PreviligeForm form) throws ParseException {
        return ResponseDto.<PreviligeDto>builder()
                .success(true)
                .data(PreviligeDto.toDto(repository.save(fill(new Previlige(), form))))
                .build();
    }

    @Override
    public ResponseDto<PreviligeDto> update(Integer id, PreviligeForm form) throws ParseException {
        return ResponseDto.<PreviligeDto>builder()
                .success(true)
                .data(PreviligeDto.toDto(repository.save(fill(get(id), form))))
                .build();
    }

    @Override
    public void delete(Integer id) {
        Previlige previlige = get(id);
        previlige.setDeleted(true);
        repository.save(previlige);
    }

    public Previlige fill(Previlige previlige, PreviligeForm form) throws ParseException {
        previlige.setPrevilige(form.getPrevilige());
        previlige.setName(form.getName());
        return previlige;
    }

    public Previlige get(Integer id) {
        return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ObjectNotFoundException(id.toString(), "Previlige"));
    }
}
