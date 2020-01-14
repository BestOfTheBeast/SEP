package student.enterprise.project.converter;

import java.util.List;

public interface ModelEntityConverter<ENTITY, DTO> {

  List<DTO> toDto(Iterable<ENTITY> entities);

  DTO toDto(ENTITY entity);

}
