package uz.online.teacher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.online.teacher.entity.FileItem;

import java.util.List;
import java.util.Optional;

public interface FileItemRepository extends JpaRepository<FileItem, Integer> {
    Optional<FileItem> findByIdAndDeletedFalse(Long id);

    List<FileItem> findAllByDeletedFalse();

    Optional<FileItem> findByUidAndDeletedFalse(String uid);

    @Query(value = "select  * from files where uid in :uids and deleted = false", nativeQuery = true)
    List<FileItem> findByUids(List<String> uids);
}
