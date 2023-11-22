package uz.online.teacher.repository;

import org.apache.catalina.LifecycleState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.online.teacher.entity.Region;

import java.util.List;
import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Integer> {
    Optional<Region> findByIdAndDeletedFalse(Integer id);
    List<Region> findAllByDeletedFalse();
    Page<Region> findAllByDeletedFalse(Pageable pageable);
}
