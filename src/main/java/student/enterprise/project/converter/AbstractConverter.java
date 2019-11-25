package student.enterprise.project.converter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.modelmapper.ModelMapper;

public abstract class AbstractConverter<ENTITY, DTO> implements
    ModelConverter<ENTITY, DTO> {

  protected final ModelMapper mapper;
  private final Class<ENTITY> entityClass;
  private final Class<DTO> dtoClass;

  public AbstractConverter(Class<ENTITY> entityClass, Class<DTO> dtoClass, ModelMapper mapper) {
    this.entityClass = entityClass;
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
