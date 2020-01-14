package student.enterprise.project.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import student.enterprise.project.converter.impl.ChangeConverter;
import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.entity.ChangeEntity;
import student.enterprise.project.service.ChangeService;

@RequiredArgsConstructor
//TODO rename service
public class ChangeServiceImpl implements ChangeService {

  private final ChangeConverter changeConverter;

  @Override
  public List<ChangeDTO> toDto(ChangeEntity entity) {
    return Arrays.stream(changeConverter.toDto(entity))
        .collect(Collectors.toList());
  }
}
