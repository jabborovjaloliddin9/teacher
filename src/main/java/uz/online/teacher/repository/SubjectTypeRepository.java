package uz.online.teacher.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.online.teacher.entity.Region;
import uz.online.teacher.entity.SubjectType;

import java.util.List;
import java.util.Optional;

public interface SubjectTypeRepository extends JpaRepository<SubjectType, Integer> {
    Optional<SubjectType> findByIdAndDeletedFalse(Integer id);
    List<SubjectType> findAllByDeletedFalse();
    Page<SubjectType> findAllByDeletedFalse(Pageable pageable);
}
