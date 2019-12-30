package student.enterprise.project.service.impl;

import org.springframework.stereotype.Service;
import student.enterprise.project.converter.impl.ChangeConverter;
import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.entity.ChangeEntity;
import student.enterprise.project.service.ChangeService;

import java.util.*;

@Service
public class ChangeServiceImpl implements ChangeService {
    private final ChangeConverter changeConverter;

    public ChangeServiceImpl(ChangeConverter changeConverter) {
        this.changeConverter = changeConverter;
    }

    @Override
    public List<ChangeDTO> toDto(ChangeEntity entity) {
        if (Objects.isNull(entity)) {
            return Collections.emptyList();
        }
        return Arrays.asList(changeConverter.toDto(entity));
    }

}

