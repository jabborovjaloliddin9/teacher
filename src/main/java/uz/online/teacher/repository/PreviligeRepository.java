package uz.online.teacher.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.online.teacher.entity.FileItem;
import uz.online.teacher.entity.Previlige;

import java.util.List;
import java.util.Optional;

public interface PreviligeRepository extends JpaRepository<Previlige, Integer> {
    Optional<Previlige> findByIdAndDeletedFalse(Integer id);
    List<Previlige> findAllByDeletedFalse();
    Page<Previlige> findAllByDeletedFalse(Pageable pageable);
    @Query(value = "select  * from previlige where id in :id and deleted = false", nativeQuery = true)
    List<Previlige> findByIds(List<Integer> id);
    Optional<Previlige> findByPreviligeAndDeletedFalse(String previliege);
}
