package uz.online.teacher.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.online.teacher.entity.SchoolYear;

import java.util.List;
import java.util.Optional;

public interface SchoolYearRepository extends JpaRepository<SchoolYear, Integer> {
    Optional<SchoolYear> findByIdAndDeletedFalse(Integer id);
    List<SchoolYear> findAllByDeletedFalse();
    Page<SchoolYear> findAllByDeletedFalse(Pageable pageable);
    @Query(value = "select * from school_year where is_active = true", nativeQuery = true)
    Optional<SchoolYear> getCurrentSchoolYear();
}
