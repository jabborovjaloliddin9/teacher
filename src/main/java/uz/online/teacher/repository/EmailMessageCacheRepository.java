package uz.online.teacher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import uz.online.teacher.entity.cache.EmailMessageCode;

import java.util.Optional;

@Repository
public interface EmailMessageCacheRepository extends CrudRepository<EmailMessageCode, String> {
    Optional<EmailMessageCode> findBySessionId(String sessionId);
}
