package student.enterprise.project.converter.impl;

import java.util.Objects;
import org.modelmapper.ModelMapper;
import student.enterprise.project.converter.AbstractEntityConverter;
import student.enterprise.project.converter.Converter;
import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.entity.ChangeEntity;
import student.enterprise.project.entity.RepeatableChangeEntity;
import student.enterprise.project.entity.SingleChangeEntity;

@Converter
public class ChangeEntityConverter extends AbstractEntityConverter<ChangeEntity, ChangeDTO[]> {

  private final RepeatableChangeEntityConverter repeatableChangeConverter;
  private final SingleChangeEntityConverter singleChangeConverter;

  public ChangeEntityConverter(ModelMapper mapper,
      RepeatableChangeEntityConverter repeatableChangeConverter,
      SingleChangeEntityConverter singleChangeConverter) {
    super(ChangeDTO[].class, mapper);
    this.repeatableChangeConverter = repeatableChangeConverter;
    this.singleChangeConverter = singleChangeConverter;
  }

  @Override
  public ChangeDTO[] toDto(ChangeEntity entity) {
    if (Objects.isNull(entity)) {
      return new ChangeDTO[]{};
    }
    if (entity instanceof SingleChangeEntity) {
      return new ChangeDTO[]{singleChangeConverter.toDto((SingleChangeEntity) entity)};
    } else if (entity instanceof RepeatableChangeEntity) {
      return repeatableChangeConverter.toDto((RepeatableChangeEntity) entity);
    }
    return new ChangeDTO[]{};
  }

}
