//package uz.online.teacher.controller;
//
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import uz.online.teacher.dto.PersonDto;
//import uz.online.teacher.dto.ResponseDto;
//import uz.online.teacher.dto.form.PersonForm;
//import uz.online.teacher.service.PersonService;
//import uz.online.teacher.service.PersonService;
//
//import java.text.ParseException;
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("Person")
//public class PersonController {
//
//    private final PersonService service;
//
//    @GetMapping("{id}")
//    public ResponseEntity<ResponseDto<PersonDto>> getOne(@PathVariable Integer id) {
//        return ResponseEntity.ok(service.getOne(id));
//    }
//
//    @GetMapping
//    public ResponseEntity<ResponseDto<List<PersonDto>>> findAll() {
//        return ResponseEntity.ok(service.findAll());
//    }
//
//    @PostMapping
//    public ResponseEntity<ResponseDto<PersonDto>> create(@RequestBody @Valid PersonForm form) throws ParseException {
//        return ResponseEntity.ok(service.create(form));
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<ResponseDto<PersonDto>> update(@PathVariable Integer id, @RequestBody @Valid PersonForm form) throws ParseException {
//        return ResponseEntity.ok(service.update(id, form));
//    }
//
//    @DeleteMapping("{id}")
//    public void delete(@PathVariable Integer id) {
//        service.delete(id);
//    }
//}
