package student.enterprise.project.service;

import org.springframework.stereotype.Service;
import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.entity.ChangeEntity;

import java.util.List;

@Service
public interface ChangeService {

    List<ChangeDTO> toDto(ChangeEntity entity);

}
