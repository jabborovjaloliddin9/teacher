package uz.online.teacher.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.online.teacher.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByIdAndDeletedFalse(Integer id);
    Page<User> findAllByDeletedFalse(Pageable pageable);
    Optional<User> findByUsernameAndDeletedFalse(String username);
    boolean existsByPhoneAndDeletedFalse(String phone);
    boolean existsByEmailAndDeletedFalse(String email);
    boolean existsByUsernameAndDeletedFalse(String username);
    boolean existsByParentPhoneAndDeletedFalse(String parentPhone);
    boolean existsByDocumentSerialAndDocumentNumberAndDeletedFalse(String documentSerial, String documentNumber);
    Optional<User> findByEmailAndDeletedFalse(String email);
}
