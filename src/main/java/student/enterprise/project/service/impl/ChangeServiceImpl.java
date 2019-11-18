package student.enterprise.project.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.entity.ChangeEntity;
import student.enterprise.project.entity.RepeatableChangeEntity;
import student.enterprise.project.entity.SingleChangeEntity;
import student.enterprise.project.service.ChangeService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ChangeServiceImpl implements ChangeService {

    private final ModelMapper mapper;

    public ChangeServiceImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<ChangeDTO> toDto(ChangeEntity entity) {
        if (Objects.isNull(entity)) {
            return Collections.emptyList();
        }
        if (entity instanceof SingleChangeEntity) {
            return Collections.singletonList(mapper.map(entity, ChangeDTO.class));
        } else if (entity instanceof RepeatableChangeEntity) {
            List<ChangeDTO> changeDTOList = new ArrayList<>();
            for (LocalDate date = ((RepeatableChangeEntity) entity).getRepeatDate();
                 date.isBefore(((RepeatableChangeEntity) entity).getEndDate());
                 date = date.plusDays(((RepeatableChangeEntity) entity).getFrequency().getDays())) {
                changeDTOList.add(new ChangeDTO(
                        entity.getId(),
                        entity.getLessonEntity(),
                        entity.getSubjectEntity(),
                        entity.getLecturerEntity(),
                        date));
            }
            return changeDTOList;
        }
        return Collections.emptyList();
    }
}
