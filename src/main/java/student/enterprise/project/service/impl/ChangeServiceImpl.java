package student.enterprise.project.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import student.enterprise.project.converter.impl.ChangeEntityConverter;
import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.entity.ChangeEntity;
import student.enterprise.project.service.ChangeService;

@RequiredArgsConstructor
//TODO rename service
public class ChangeServiceImpl implements ChangeService {

  private final ChangeEntityConverter changeConverter;

  @Override
  public List<ChangeDTO> toDto(ChangeEntity entity) {
    return Arrays.stream(changeConverter.toDto(entity))
        .collect(Collectors.toList());
  }

  @Override
  public List<ChangeDTO> toDto(List<ChangeEntity> entityList) {
    return entityList.stream()
        .flatMap(entity -> this.toDto(entity).stream())
        .collect(Collectors.toList());
  }
}
