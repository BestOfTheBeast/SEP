package student.enterprise.project.converter.impl;

import org.modelmapper.ModelMapper;
import student.enterprise.project.converter.AbstractConverter;
import student.enterprise.project.converter.Converter;
import student.enterprise.project.dto.LessonDTO;
import student.enterprise.project.entity.LessonEntity;

@Converter
public class LessonConverter extends AbstractConverter<LessonEntity, LessonDTO> {

  public LessonConverter(ModelMapper mapper) {
    super(LessonEntity.class, LessonDTO.class, mapper);
  }

}
