package student.enterprise.project.converter.impl;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import student.enterprise.project.converter.AbstractEntityConverter;
import student.enterprise.project.converter.Converter;
import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.entity.LecturerEntity;
import student.enterprise.project.entity.SingleChangeEntity;
import student.enterprise.project.entity.SubjectEntity;

@Converter
public class SingleChangeEntityConverter extends AbstractEntityConverter<SingleChangeEntity, ChangeDTO> {

  private final LessonEntityConverter lessonConverter;

  public SingleChangeEntityConverter(ModelMapper mapper,
      LessonEntityConverter lessonConverter) {
    super(ChangeDTO.class, mapper);
    this.lessonConverter = lessonConverter;
  }

  @Override
  public ChangeDTO toDto(SingleChangeEntity entity) {
    return ChangeDTO.builder()
        .id(entity.getId())
        .date(entity.getDate())
        .lecturerId(Optional.ofNullable(entity.getLecturerEntity()).map(LecturerEntity::getId).orElse(null))
        .subjectId(Optional.ofNullable(entity.getSubjectEntity()).map(SubjectEntity::getId).orElse(null))
        .lessonDTO(lessonConverter.toDto(entity.getLessonEntity()))
        .build();
  }
}
