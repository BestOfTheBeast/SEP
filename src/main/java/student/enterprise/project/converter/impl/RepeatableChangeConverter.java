package student.enterprise.project.converter.impl;

import com.google.common.collect.Lists;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import student.enterprise.project.converter.AbstractConverter;
import student.enterprise.project.converter.Converter;
import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.entity.LecturerEntity;
import student.enterprise.project.entity.RepeatableChangeEntity;
import student.enterprise.project.entity.SubjectEntity;
import student.enterprise.project.utils.DateUtil;
import student.enterprise.project.utils.NumberUtil;

@Converter
public class RepeatableChangeConverter extends AbstractConverter<RepeatableChangeEntity, ChangeDTO[]> {

  private final LessonConverter lessonConverter;

  public RepeatableChangeConverter(ModelMapper mapper,
      LessonConverter lessonConverter) {
    super(RepeatableChangeEntity.class, ChangeDTO[].class, mapper);
    this.lessonConverter = lessonConverter;
  }

  @Override
  public ChangeDTO[] toDto(RepeatableChangeEntity entity) {
    final Short twoWeekFlag = entity.getTwoWeekFlag();
    List<ChangeDTO> result = Lists.newArrayList();
    LocalDate tempDate = entity.getStartDate();
    while (!tempDate.isAfter(entity.getEndDate())) {
      final Integer dayOfTwoWeeks = DateUtil.getDayOfTwoWeeks(tempDate);
      if (NumberUtil.getBitAtPosition(twoWeekFlag, dayOfTwoWeeks)) {
        result.add(ChangeDTO.builder()
            .id(entity.getId())
            .date(tempDate)
            .lecturerId(Optional.ofNullable(entity.getLecturerEntity()).map(LecturerEntity::getId).orElse(null))
            .subjectId(Optional.ofNullable(entity.getSubjectEntity()).map(SubjectEntity::getId).orElse(null))
            .lessonDTO(lessonConverter.toDto(entity.getLessonEntity()))
            .build());
      }
      tempDate = tempDate.plusDays(1);
    }
    return result.toArray(new ChangeDTO[0]);
  }

}
