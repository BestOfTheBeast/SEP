package student.enterprise.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.enterprise.project.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
