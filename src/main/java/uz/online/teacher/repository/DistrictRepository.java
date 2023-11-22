package uz.online.teacher.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.online.teacher.entity.District;

import java.util.List;
import java.util.Optional;

public interface DistrictRepository extends JpaRepository<District, Integer> {
    Optional<District> findByIdAndDeletedFalse(Integer id);
    List<District> findAllByDeletedFalse();

    @Query(value = "select * from district where deleted = false and (region_id = :regionid or :regionid = 0)", nativeQuery = true)
    List<District> findRegionDistrict(@Param("regionid") Integer regionid);
    @Query(value = "select * from district where deleted = false and (region_id = :regionid or :regionid = 0)", nativeQuery = true)
    Page<District> findRegionDistrictPaged(@Param("regionid") Integer regionid, Pageable pageable);
}
