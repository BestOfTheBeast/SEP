package student.enterprise.project.converter.impl;
import org.modelmapper.ModelMapper;
import student.enterprise.project.converter.AbstractConverter;
import student.enterprise.project.converter.Converter;
import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.entity.*;

import java.util.Optional;

@Converter
public class RepeatableChangeConverter extends AbstractConverter<RepeatableChangeEntity, ChangeDTO> {
    private final LessonConverter lessonConverter;

    public RepeatableChangeConverter(ModelMapper mapper, LessonConverter lessonConverter) {
        super(RepeatableChangeEntity.class, ChangeDTO.class, mapper);
        this.lessonConverter = lessonConverter;
    }

    @Override
    public ChangeDTO toDto(RepeatableChangeEntity entity) {
        return ChangeDTO.builder()
                .id(entity.getId())
                .date(entity.getStartDate())     // надо уточнить
                .lecturerId(Optional.ofNullable(entity.getLecturerEntity()).map(LecturerEntity::getId).orElse(null))
                .subjectId(Optional.ofNullable(entity.getSubjectEntity()).map(SubjectEntity::getId).orElse(null))
                .lessonDTO(lessonConverter.toDto(entity.getLessonEntity()))
                .build();
    }

}
