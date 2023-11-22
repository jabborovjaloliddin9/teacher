package uz.online.teacher.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.online.teacher.entity.*;
import uz.online.teacher.enums.UserRole;
import uz.online.teacher.exception.ObjectNotFoundException;
import uz.online.teacher.repository.*;
import uz.online.teacher.service.InitialInsertionService;
import uz.online.teacher.utils.DateTimeUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class InitialInsertionServiceImple implements InitialInsertionService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final GenderRepository genderRepository;
    private final PreviligeRepository previligeRepository;
    private final SubjectTypeRepository subjectTypeRepository;
    private final SubjectRepository subjectRepository;
    private final RegionRepository regionRepository;
    private final SchoolYearRepository schoolYearRepository;
    private final WeekDayRepository weekDayRepository;
    private final TarifRepository tarifRepository;

    @PostConstruct
    @Transactional
    public void initialPreviligeAuthorityUserGenderInsertion() {

        Previlige readPrevilige = previligeRepository.findByPreviligeAndDeletedFalse("read")
                .orElseGet(() -> {
                    log.info("read previlige is saved!");
                    return Previlige.builder()
                            .previlige("read")
                            .name(new LocalizedString("o`qish", "читать", "read"))
                            .build();
                });

        Previlige writePrevilige = previligeRepository.findByPreviligeAndDeletedFalse("write")
                .orElseGet(() -> {
                    log.info("write previlige is saved!");
                    return Previlige.builder()
                            .previlige("write")
                            .name(new LocalizedString("yozish", "записывать", "write"))
                            .build();
                });

        Previlige deletePrevilige = previligeRepository.findByPreviligeAndDeletedFalse("delete")
                .orElseGet(() -> {
                    log.info("delete previlige is saved!");
                    return Previlige.builder()
                            .previlige("delete")
                            .name(new LocalizedString("o`chirish", "удалить", "delete"))
                            .build();
                });

        previligeRepository.saveAll(List.of(writePrevilige, readPrevilige, deletePrevilige));

        var adminAuthority = authorityRepository.findByAuthorityAndDeletedFalse(UserRole.ADMIN.name())
                .orElseGet(() -> {
                    log.info("ADMIN authority is saved!");
                    return Authority.builder()
                            .authority(UserRole.ADMIN.name())
                            .name(new LocalizedString("admin", "админ", "admin"))
                            .build();
                });

        adminAuthority.setPreviliges(List.of(readPrevilige, writePrevilige, deletePrevilige));

        var organizationAuthority = authorityRepository.findByAuthorityAndDeletedFalse(UserRole.ORGANIZATION.name())
                .orElseGet(() -> {
                    log.info("ORGANIZATION authority is saved!");
                    return Authority.builder()
                            .authority(UserRole.ORGANIZATION.name())
                            .name(new LocalizedString("tashkilot", "организация", "organization"))
                            .build();
                });

        organizationAuthority.setPreviliges(List.of(readPrevilige, writePrevilige, deletePrevilige));

        var teacherAuthority = authorityRepository.findByAuthorityAndDeletedFalse(UserRole.TEACHER.name())
                .orElseGet(() -> {
                    log.info("TEACHER authority is saved!");
                    return Authority.builder()
                            .authority(UserRole.TEACHER.name())
                            .name(new LocalizedString("o`qituvchi", "учитель", "teacher"))
                            .build();
                });

        teacherAuthority.setPreviliges(List.of(readPrevilige, writePrevilige, deletePrevilige));

        var studentAuthority = authorityRepository.findByAuthorityAndDeletedFalse(UserRole.STUDENT.name())
                .orElseGet(() -> {
                    log.info("STUDENT authority is saved!");
                    return Authority.builder()
                            .authority(UserRole.STUDENT.name())
                            .name(new LocalizedString("o`quvchi", "студент", "student"))
                            .build();
                });

        studentAuthority.setPreviliges(List.of(readPrevilige));

        authorityRepository.saveAll(List.of(adminAuthority, organizationAuthority, teacherAuthority, studentAuthority));

        Gender manGender;
        Gender womanGender = null;
        if (genderRepository.count() == 0) {
            manGender = Gender.builder()
                    .name(new LocalizedString("erkak", "мужской", "man"))
                    .build();
            womanGender = Gender.builder()
                    .name(new LocalizedString("ayol", "женский", "woman"))
                    .build();

            genderRepository.saveAll(List.of(manGender, womanGender));
            log.info("genders is saved!");
        } else {
            manGender = genderRepository.findByIdAndDeletedFalse(1)
                    .orElseThrow(() -> new RuntimeException("Gender not found"));
        }

        if (userRepository.count() == 0) {
            User user = userRepository.findByUsernameAndDeletedFalse("jaloliddin9")
                    .orElseGet(() -> {
                        try {
                            return User.builder()
                                    .firstName("Jaloliddin")
                                    .lastName("Jabborov")
                                    .secondName("Faxriddinovich")
                                    .fullName("Jabborov Jaloliddin Faxriddinovich")
                                    .birthDate(DateTimeUtils.toDate("yyyy-MM-dd", "1992-06-20"))
                                    .gender(manGender)
                                    .documentSerial("AC")
                                    .documentNumber("3083665")
                                    .email("jabborovjaloliddin9@gmailcom")
                                    .phone("998937957093")
                                    .username("jaloliddin9")
                                    .password("$2a$12$nnzO77RGPksD3y6ozGd89uv5mJmpAEWRfvxGIRL.4o0qLXNsYuGse")
                                    .authority(adminAuthority)
                                    .build();
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    });

            log.info("admin user is saved!");
            user.setAuthority(adminAuthority);
            userRepository.save(user);
        }
    }

    @PostConstruct
    @Transactional
    public void initialRegionDistrictInsertion() {
        if (regionRepository.count() == 0) {
            regionRepository.saveAll(
                    List.of(
                            Region.builder().name(new LocalizedString("Toshkent shahri", "город Ташкент", "Tashkent city")).build(),
                            Region.builder().name(new LocalizedString("Sirdaryo", "Сырдарья", "Syrdarya")).build(),
                            Region.builder().name(new LocalizedString("Jizzax", "Джизак", "Jizzakh")).build(),
                            Region.builder().name(new LocalizedString("Samarqand", "Самарканд", "Samarkand")).build(),
                            Region.builder().name(new LocalizedString("Qashqadaryo", "Кашкадарья", "Kashkadarya")).build(),
                            Region.builder().name(new LocalizedString("Surxondaryo", "Сурхандарьинская", "Surkhandarya")).build(),
                            Region.builder().name(new LocalizedString("Buxoro", "Бухара", "Bukhara")).build(),
                            Region.builder().name(new LocalizedString("Navoiy", "Навои", "Navoi")).build(),
                            Region.builder().name(new LocalizedString("Xorazm", "Хорезм", "Khorezm")).build(),
                            Region.builder().name(new LocalizedString("Qaraqalpog`iston", "Каракалпакстан", "Karakalpakstan")).build(),
                            Region.builder().name(new LocalizedString("Farg`na", "Фергана", "Fergana")).build(),
                            Region.builder().name(new LocalizedString("Namangan", "Наманган", "Namangan")).build(),
                            Region.builder().name(new LocalizedString("Toshkent", "Ташкент", "Tashkent")).build(),
                            Region.builder().name(new LocalizedString("Andijon", "Андижан", "Andijan")).build()
                    )
            );
            log.info("regions are saved!");
        }
    }

    @PostConstruct
    @Transactional
    public void initialSubjectTypeSubjectInsertion() {

        SubjectType theoretical = null;
        SubjectType practical = null;
        if (subjectTypeRepository.count() == 0) {
            theoretical = SubjectType.builder().name(new LocalizedString("Nazariy", "Теоретический", "Theoretical")).build();
            practical = SubjectType.builder().name(new LocalizedString("Amaliy", "Практичный", "Practical")).build();
            subjectTypeRepository.saveAll(List.of(theoretical, practical));
        } else {
            theoretical = subjectTypeRepository.findByIdAndDeletedFalse(1)
                    .orElseThrow(() -> new ObjectNotFoundException("1", "subjectType"));
        }

        log.info("SubjectTypes are saved!");

        if (subjectRepository.count() == 0) {
            subjectRepository.saveAll(
                    List.of(
                            Subject.builder().name(new LocalizedString("Matematika", "Математика", "Mathematics")).subjectType(theoretical).build(),
                            Subject.builder().name(new LocalizedString("Fizika", "Физика", "Physics")).subjectType(theoretical).build(),
                            Subject.builder().name(new LocalizedString("Ona tili va adabiyot", "Родной язык и литература", "Mother tongue and literature")).subjectType(theoretical).build(),
                            Subject.builder().name(new LocalizedString("Ingliz tili", "Английский язык", "English")).subjectType(theoretical).build(),
                            Subject.builder().name(new LocalizedString("Rus tili", "Русский язык", "Russian")).subjectType(theoretical).build(),
                            Subject.builder().name(new LocalizedString("Kimyo", "Химия", "Chemistry")).subjectType(theoretical).build(),
                            Subject.builder().name(new LocalizedString("Biologiya", "Биология", "Biology")).subjectType(theoretical).build(),
                            Subject.builder().name(new LocalizedString("Tarix", "История", "History")).subjectType(theoretical).build(),
                            Subject.builder().name(new LocalizedString("Huquq", "Law", "Право")).subjectType(theoretical).build(),
                            Subject.builder().name(new LocalizedString("Geografiya", "География", "Geography")).subjectType(theoretical).build()
                    )
            );
            log.info("Subjects are saved!");
        }
    }

    @Override
    @PostConstruct
    public void initialSchoolYearInsertion() throws ParseException {
        if (schoolYearRepository.count() == 0) {
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            schoolYearRepository.save(SchoolYear.builder()
                    .name(currentYear + "-" + (currentYear + 1))
                    .startDate(DateTimeUtils.toDate("yyyy-MM-dd", currentYear + "-09-02"))
                    .endDate(DateTimeUtils.toDate("yyyy-MM-dd", (currentYear + 1) + "-31-08"))
                    .isActive(true)
                    .build());
            log.info("School year is save!");
        }
    }

    @PostConstruct
    public void initialWeekDayInsertion() {
        if (weekDayRepository.count() == 0) {
            weekDayRepository.saveAll(List.of(
                    WeekDay.builder().name(new LocalizedString("Dushanba", "Понедельник", "Monday")).build(),
                    WeekDay.builder().name(new LocalizedString("Seshanba", "Вторник", "Tuesday")).build(),
                    WeekDay.builder().name(new LocalizedString("Chorshanba", "Среда", "Wednesday")).build(),
                    WeekDay.builder().name(new LocalizedString("Payshanba", "Четверг", "Thursday")).build(),
                    WeekDay.builder().name(new LocalizedString("Juma", "Пятница", "Friday")).build(),
                    WeekDay.builder().name(new LocalizedString("Shanba", "Суббота", "Saturday")).build(),
                    WeekDay.builder().name(new LocalizedString("Yakshanba", "Воскресенье", "Sunday")).build()
            ));
            log.info("Week days is saved!");
        }
    }

    @PostConstruct
    public void initialTarifInsertion() {
        if (tarifRepository.count() == 0) {
            tarifRepository.saveAll(List.of(
                    Tarif.builder().name(new LocalizedString("Kunlik", "Ежедневно", "Daily")).build(),
                    Tarif.builder().name(new LocalizedString("Oylik", "Ежемесячно", "Monthly")).build(),
                    Tarif.builder().name(new LocalizedString("Olti oylik", "Шесть месяцев", "Six month")).build(),
                    Tarif.builder().name(new LocalizedString("Yillik", "Ежегодно", "Yearly")).build()
            ));
        }
    }
}
