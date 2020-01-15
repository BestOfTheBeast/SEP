package student.enterprise.project.service;

import java.util.List;
import org.springframework.stereotype.Service;
import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.entity.ChangeEntity;

@Service
public interface ChangeService {

    List<ChangeDTO> toDto(ChangeEntity entity);

    List<ChangeDTO> toDto(List<ChangeEntity> entity);

}
