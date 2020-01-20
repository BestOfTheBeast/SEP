package student.enterprise.project.converter.impl;

import org.modelmapper.ModelMapper;
import student.enterprise.project.converter.AbstractEntityConverter;
import student.enterprise.project.converter.Converter;
import student.enterprise.project.dto.LessonDTO;
import student.enterprise.project.entity.LessonEntity;

@Converter
public class LessonEntityConverter extends AbstractEntityConverter<LessonEntity, LessonDTO> {

  public LessonEntityConverter(ModelMapper mapper) {
    super(LessonDTO.class, mapper);
  }

}
