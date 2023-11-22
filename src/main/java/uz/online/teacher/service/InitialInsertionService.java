package uz.online.teacher.service;

import java.text.ParseException;

public interface InitialInsertionService {
    void initialPreviligeAuthorityUserGenderInsertion();
    void initialRegionDistrictInsertion();
    void initialSubjectTypeSubjectInsertion();
    void initialSchoolYearInsertion() throws ParseException;
    void initialWeekDayInsertion();
    void initialTarifInsertion();
}
