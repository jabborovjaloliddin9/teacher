//package uz.online.teacher.service.impl;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import uz.online.teacher.dto.PersonDto;
//import uz.online.teacher.dto.ResponseDto;
//import uz.online.teacher.dto.form.PersonForm;
//import uz.online.teacher.entity.Person;
//import uz.online.teacher.exception.ObjectNotFoundException;
//import uz.online.teacher.repository.AddressRepository;
//import uz.online.teacher.repository.GenderRepository;
//import uz.online.teacher.repository.PersonRepository;
//import uz.online.teacher.service.PersonService;
//import uz.online.teacher.utils.DateTimeUtils;
//
//import java.text.ParseException;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class PersonServiceImpl implements PersonService {
//
//    private final PersonRepository repository;
//    private final GenderRepository genderRepository;
//    private final AddressRepository addressRepository;
//
//    @Override
//    public ResponseDto<PersonDto> getOne(Integer id) {
//        return ResponseDto.<PersonDto>builder()
//                .success(true)
//                .data(PersonDto.toDto(get(id)))
//                .build();
//    }
//
//    @Override
//    public ResponseDto<List<PersonDto>> findAll() {
//        return ResponseDto.<List<PersonDto>>builder()
//                .success(true)
//                .data(repository.findAllByDeletedFalse().stream().map(PersonDto::toDto).toList())
//                .build();
//    }
//
//    @Override
//    public ResponseDto<PersonDto> create(PersonForm form) throws ParseException {
//        return ResponseDto.<PersonDto>builder()
//                .success(true)
//                .data(PersonDto.toDto(repository.save(fill(new Person(), form))))
//                .build();
//    }
//
//    @Override
//    public ResponseDto<PersonDto> update(Integer id, PersonForm form) throws ParseException {
//        return ResponseDto.<PersonDto>builder()
//                .success(true)
//                .data(PersonDto.toDto(repository.save(fill(get(id), form))))
//                .build();
//    }
//
//    @Override
//    public void delete(Integer id) {
//        Person person = get(id);
//        person.setDeleted(true);
//        repository.save(person);
//    }
//
//    public Person fill(Person person, PersonForm form) throws ParseException {
//        person.setFirstName(form.getFirstName());
//        person.setLastName(form.getLastName());
//        person.setSecondName(form.getSecondName());
//        person.setFullName(form.getFirstName() + " " + form.getLastName() + " " + form.getSecondName());
//        person.setBirthDate(DateTimeUtils.toDate("yyyy-MM-dd", form.getBirthDate()));
//        person.setGender(genderRepository.findByIdAndDeletedFalse(form.getGenderId())
//                .orElseThrow(()-> new ObjectNotFoundException(form.getGenderId().toString(), "gender")));
//        person.setDocumentNumber(form.getDocumentNumber());
//        person.setDocumentSerial(form.getDocumentSerial());
//        person.setPhone(form.getPhone());
//        person.setEmail(form.getEmail());
//        person.setAddress(addressRepository.findByIdAndDeletedFalse(form.getAddressId())
//                .orElseThrow(()-> new ObjectNotFoundException(form.getAddressId().toString(), "Address")));
//        return person;
//    }
//
//    public Person get(Integer id) {
//        return repository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ObjectNotFoundException(id.toString(), "user"));
//    }
//}
