package student.enterprise.project.converter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.modelmapper.ModelMapper;

public abstract class AbstractDtoConverter<ENTITY, DTO> implements
    ModelDtoConverter<ENTITY, DTO> {

  protected final ModelMapper mapper;
  private final Class<ENTITY> entityClass;

  public AbstractDtoConverter(Class<ENTITY> entityClass, ModelMapper mapper) {
    this.entityClass = entityClass;
    this.mapper = mapper;
  }

  @Override
  public List<ENTITY> toEntity(Iterable<DTO> dtos) {
    return StreamSupport.stream(dtos.spliterator(), false)
        .map(this::toEntity)
        .collect(Collectors.toList());
  }

  @Override
  public ENTITY toEntity(DTO dto) {
    return dto == null ? null : mapper.map(dto, entityClass);
  }
}
