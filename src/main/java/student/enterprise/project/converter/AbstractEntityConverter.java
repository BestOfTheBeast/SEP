package student.enterprise.project.converter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.modelmapper.ModelMapper;

public abstract class AbstractEntityConverter<ENTITY, DTO> implements
    ModelEntityConverter<ENTITY, DTO> {

  protected final ModelMapper mapper;
  private final Class<DTO> dtoClass;

  public AbstractEntityConverter(Class<DTO> dtoClass, ModelMapper mapper) {
    this.dtoClass = dtoClass;
    this.mapper = mapper;
  }

  @Override
  public List<DTO> toDto(Iterable<ENTITY> entities) {
    return StreamSupport.stream(entities.spliterator(), false)
        .map(this::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public DTO toDto(ENTITY entity) {
    return entity == null ? null : mapper.map(entity, dtoClass);
  }

}
