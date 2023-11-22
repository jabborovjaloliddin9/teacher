package uz.online.teacher.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.online.teacher.dto.TarifDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.form.TarifForm;
import uz.online.teacher.entity.Tarif;
import uz.online.teacher.exception.ObjectNotFoundException;
import uz.online.teacher.repository.TarifRepository;
import uz.online.teacher.service.TarifService;

import java.text.ParseException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TarifServiceImpl implements TarifService {

    private final TarifRepository repository;

    @Override
    public ResponseDto<TarifDto> getOne(Integer id) {
        return ResponseDto.<TarifDto>builder()
                .success(true)
                .data(TarifDto.toDto(get(id)))
                .build();
    }

    @Override
    public ResponseDto<List<TarifDto>> getAll() {
        return ResponseDto.<List<TarifDto>>builder()
                .success(true)
                .data(repository.findAllByDeletedFalse().stream().map(TarifDto::toDto).toList())
                .build();
    }

    @Override
    public ResponseDto<Page<TarifDto>> getList(Integer page, Integer size) {
        return ResponseDto.<Page<TarifDto>>builder()
                .success(true)
                .data(repository.findAllByDeletedFalse(PageRequest.of(page, size)).map(TarifDto::toDto))
                .build();
    }

    @Override
    public ResponseDto<TarifDto> create(TarifForm form) throws ParseException {
        return ResponseDto.<TarifDto>builder()
                .success(true)
                .data(TarifDto.toDto(repository.save(fill(new Tarif(), form))))
                .build();
    }

    @Override
    public ResponseDto<TarifDto> update(Integer id, TarifForm form) throws ParseException {
        return ResponseDto.<TarifDto>builder()
                .success(true)
                .data(TarifDto.toDto(repository.save(fill(get(id), form))))
                .build();
    }

    @Override
    public void delete(Integer id) {
        Tarif tarif = get(id);
        tarif.setDeleted(true);
        repository.save(tarif);
    }

    public Tarif fill(Tarif tarif, TarifForm form) throws ParseException {
        tarif.setName(form.getName());
        return tarif;
    }

    public Tarif get(Integer id) {
        return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ObjectNotFoundException(id.toString(), "Tarif"));
    }
}
