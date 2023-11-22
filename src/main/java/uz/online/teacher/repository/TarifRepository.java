package uz.online.teacher.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.online.teacher.entity.Tarif;

import java.util.List;
import java.util.Optional;

public interface TarifRepository extends JpaRepository<Tarif, Integer> {
    Optional<Tarif> findByIdAndDeletedFalse(Integer id);
    List<Tarif> findAllByDeletedFalse();
    Page<Tarif> findAllByDeletedFalse(Pageable pageable);
}
