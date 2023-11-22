package uz.online.teacher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.online.teacher.entity.Gender;
import java.util.List;
import java.util.Optional;

public interface GenderRepository extends JpaRepository<Gender, Integer> {
    Optional<Gender> findByIdAndDeletedFalse(Integer id);
    List<Gender> findAllByDeletedFalse();
}
