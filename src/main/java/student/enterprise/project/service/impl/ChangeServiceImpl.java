package student.enterprise.project.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import student.enterprise.project.converter.impl.RepeatableChangeConverter;
import student.enterprise.project.converter.impl.SingleChangeConverter;
import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.entity.ChangeEntity;
import student.enterprise.project.entity.RepeatableChangeEntity;
import student.enterprise.project.entity.SingleChangeEntity;
import student.enterprise.project.service.ChangeService;

@RequiredArgsConstructor
//TODO rename service
public class ChangeServiceImpl implements ChangeService {

  private final RepeatableChangeConverter repeatableChangeConverter;
  private final SingleChangeConverter singleChangeConverter;

  @Override
  public List<ChangeDTO> toDto(ChangeEntity entity) {
    if (Objects.isNull(entity)) {
      return Collections.emptyList();
    }
    if (entity instanceof SingleChangeEntity) {
      return Collections.singletonList(singleChangeConverter.toDto((SingleChangeEntity) entity));
    } else if (entity instanceof RepeatableChangeEntity) {
      return Arrays.stream(repeatableChangeConverter.toDto((RepeatableChangeEntity) entity))
          .collect(Collectors.toList());
    }
    return Collections.emptyList();
  }
}
