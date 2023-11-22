package uz.online.teacher.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.online.teacher.entity.WeekDay;

import java.util.List;
import java.util.Optional;

public interface WeekDayRepository extends JpaRepository<WeekDay, Integer> {
    Optional<WeekDay> findByIdAndDeletedFalse(Integer id);
    List<WeekDay> findAllByDeletedFalse();
    Page<WeekDay> findAllByDeletedFalse(Pageable pageable);
}
