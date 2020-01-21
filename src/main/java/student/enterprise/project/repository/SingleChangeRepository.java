package student.enterprise.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.enterprise.project.entity.SingleChangeEntity;

public interface SingleChangeRepository extends JpaRepository<SingleChangeEntity, Long> {

}

