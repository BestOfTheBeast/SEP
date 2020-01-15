package student.enterprise.project.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import student.enterprise.project.converter.impl.ChangeEntityConverter;
import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.entity.ChangeEntity;

@Service
@RequiredArgsConstructor
public abstract class ChangeService {

    private final ChangeEntityConverter changeConverter;

    protected List<ChangeDTO> toDto(ChangeEntity entity) {
        return Arrays.stream(changeConverter.toDto(entity))
            .collect(Collectors.toList());
    }

    protected List<ChangeDTO> toDto(List<ChangeEntity> entityList) {
        return entityList.stream()
            .flatMap(entity -> this.toDto(entity).stream())
            .collect(Collectors.toList());
    }

}
