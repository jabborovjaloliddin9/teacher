package uz.online.teacher.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.online.teacher.dto.UserDto;
import uz.online.teacher.dto.ResponseDto;
import uz.online.teacher.dto.form.UserForm;
import uz.online.teacher.entity.*;
import uz.online.teacher.exception.ObjectAllreadyExistsException;
import uz.online.teacher.exception.ObjectNotFoundException;
import uz.online.teacher.repository.*;
import uz.online.teacher.service.UserService;
import uz.online.teacher.utils.DateTimeUtils;

import java.text.ParseException;
import java.util.List;

import static uz.online.teacher.constants.DateTimeConstant.toDateFormat;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final AuthorityRepository authorityRepository;
    private final GenderRepository genderRepository;
    private final PasswordEncoder passwordEncoder;
    private final SubjectRepository subjectRepository;
    private final AddressServiceImpl addressService;
    private final AddressRepository addressRepository;
    private final RegionRepository regionRepository;
    private final DistrictRepository districtRepository;

    @Override
    public ResponseDto<UserDto> getOne(Integer id) {
        return ResponseDto.<UserDto>builder()
                .success(true)
                .data(UserDto.toDto(get(id)))
                .build();
    }

    @Override
    public ResponseDto<Page<UserDto>> getList(Integer page, Integer size) {
        return ResponseDto.<Page<UserDto>>builder()
                .success(true)
                .data(repository.findAllByDeletedFalse(PageRequest.of(page, size)).map(UserDto::toDto))
                .build();
    }

    @Override
    public ResponseDto<UserDto> create(UserForm form) throws ParseException {
        User user = fill(new User(), form);
        repository.save(user);
        UserDto dto = UserDto.toDto(user);
        return ResponseDto.<UserDto>builder()
                .success(true)
                .data(dto)
                .build();
    }

    @Override
    public ResponseDto<UserDto> update(Integer id, UserForm form) throws ParseException {
        return ResponseDto.<UserDto>builder()
                .success(true)
                .data(UserDto.toDto(repository.save(fill(get(id), form))))
                .build();
    }

    @Override
    public void delete(Integer id) {
        User user = get(id);
        user.setDeleted(true);
        repository.save(user);
    }

    public User fill(User user, UserForm form) throws ParseException {
        if (repository.existsByPhoneAndDeletedFalse(form.getPhone()))
            throw new ObjectAllreadyExistsException(form.getPhone(), "phone");
        if (repository.existsByEmailAndDeletedFalse(form.getEmail()))
            throw new ObjectAllreadyExistsException(form.getEmail(), "email");
        if (repository.existsByUsernameAndDeletedFalse(form.getUsername()))
            throw new ObjectAllreadyExistsException(form.getUsername(), "username");
        if (repository.existsByParentPhoneAndDeletedFalse(form.getParentPhone()))
            throw new ObjectAllreadyExistsException(form.getParentPhone(), "parent phone");
        if (repository.existsByDocumentSerialAndDocumentNumberAndDeletedFalse(form.getDocumentSerial(), form.getDocumentNumber()))
            throw new ObjectAllreadyExistsException(form.getDocumentSerial() + " " + form.getDocumentNumber(), "document");
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setSecondName(form.getSecondName());
        user.setFullName(form.getFirstName() + " " + form.getLastName() + " " + form.getSecondName());
        user.setBirthDate(DateTimeUtils.toDate(toDateFormat, form.getBirthDate()));
        user.setGender(genderRepository.findByIdAndDeletedFalse(form.getGenderId())
                .orElseThrow(() -> new ObjectNotFoundException(form.getGenderId().toString(), "gender")));
        user.setDocumentNumber(form.getDocumentNumber());
        user.setDocumentSerial(form.getDocumentSerial());
        Authority authority = authorityRepository.findByIdAndDeletedFalse(form.getAuthorityId())
                .orElseThrow(() -> new ObjectNotFoundException(form.getAuthorityId().toString(), "authority"));
        user.setAuthority(authority);
        user.setUsername(form.getUsername());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setPhone(form.getPhone());
        user.setEmail(form.getEmail());
        user.setParentFullName(form.getParentFullName());
        if ("student".equals(authority.getAuthority()) && form.getParentPhone() == null)
            throw new RuntimeException("Student parent must have phone");
        user.setParentPhone(user.getParentPhone());
        if ("teacher".equals(authority.getAuthority()) && form.getSubjectIds().isEmpty())
            throw new RuntimeException("Teacher must have subject!");
        user.setSubjects(subjectRepository.findByIds(form.getSubjectIds()));
        if (form.getAddressForm() != null) {
            Address address = new Address();
            address.setRegion(regionRepository.findByIdAndDeletedFalse(form.getAddressForm().getRegionId())
                    .orElseThrow(() -> new ObjectNotFoundException(form.getAddressForm().getRegionId().toString(), "region")));
            address.setDistrict(districtRepository.findByIdAndDeletedFalse(form.getAddressForm().getDistrictId())
                    .orElseThrow(() -> new ObjectNotFoundException(form.getAddressForm().getDistrictId().toString(), "district")));
            address.setAddress(form.getAddressForm().getAddress());
            user.setAddress(address);
        }
        return user;
    }

    public User get(Integer id) {
        return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ObjectNotFoundException(id.toString(), "User"));
    }
}
