package student.enterprise.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.enterprise.project.entity.RepeatableChangeEntity;

public interface RepeatableChangeRepository extends JpaRepository<RepeatableChangeEntity, Long> {

}
