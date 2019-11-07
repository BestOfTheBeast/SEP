package student.enterprise.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student.enterprise.project.entity.GroupEntity;

public interface GroupRepository extends JpaRepository<GroupEntity, Long> {

}
