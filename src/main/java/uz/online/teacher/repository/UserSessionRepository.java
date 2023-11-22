package uz.online.teacher.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.online.teacher.entity.cache.UserSession;

@Repository
public interface UserSessionRepository extends CrudRepository<UserSession, String> {
}
