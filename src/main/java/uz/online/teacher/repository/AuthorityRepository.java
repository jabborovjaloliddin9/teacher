package uz.online.teacher.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.online.teacher.entity.Authority;
import uz.online.teacher.entity.Previlige;

import java.util.List;
import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    Optional<Authority> findByIdAndDeletedFalse(Integer id);
    List<Authority> findAllByDeletedFalse();
    Page<Authority> findAllByDeletedFalse(Pageable pageable);
    @Query(value = "select  * from authorities where id in :id and deleted = false", nativeQuery = true)
    List<Authority> findByIds(List<Integer> id);
    Optional<Authority> findByAuthorityAndDeletedFalse(String authority);
    boolean existsByAuthorityAndDeletedFalse(String authority);
}
