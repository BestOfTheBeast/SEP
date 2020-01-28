package student.enterprise.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.enterprise.project.entity.SubjectEntity;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {

}

