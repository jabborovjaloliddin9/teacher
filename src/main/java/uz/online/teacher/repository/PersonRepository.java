//package uz.online.teacher.repository;
//
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import uz.online.teacher.entity.Person;
//import uz.online.teacher.entity.User;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface PersonRepository extends JpaRepository<Person, Integer> {
//    Optional<Person> findByIdAndDeletedFalse(Integer id);
//    List<Person> findAllByDeletedFalse();
//}
