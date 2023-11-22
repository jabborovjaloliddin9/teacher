package uz.online.teacher.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.online.teacher.entity.Subject;
import uz.online.teacher.entity.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    Optional<Subject> findByIdAndDeletedFalse(Integer id);
    List<Subject> findAllByDeletedFalse();

    @Query(value = "select * from subject where deleted = false and (subject_type_id = :subjectTypeId or :subjectTypeId = 0)", nativeQuery = true)
    List<Subject> findSubjectSubjectType(@Param("subjectTypeId") Integer subjectTypeId);
    @Query(value = "select * from subject where deleted = false and (subject_type_id = :subjectTypeId or :subjectTypeId = 0)", nativeQuery = true)
    Page<Subject> findSubjectSubjectType(@Param("subjectTypeId") Integer subjectTypeId, Pageable pageable);

    @Query(value = "select * from subject where deleted = false and id in :ids", nativeQuery = true)
    List<Subject> findByIds(@Param("ids") List<Integer> ids);
}
