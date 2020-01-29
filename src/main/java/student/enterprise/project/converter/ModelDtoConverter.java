package student.enterprise.project.converter;

import java.util.List;

public interface ModelDtoConverter<ENTITY, DTO> {

  List<ENTITY> toEntity(Iterable<DTO> dtos);

  ENTITY toEntity(DTO dto);

}
