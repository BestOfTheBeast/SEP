package student.enterprise.project.service.impl;

import org.modelmapper.ModelMapper;
import student.enterprise.project.converter.impl.SingleChangeConverter;
import student.enterprise.project.converter.impl.LessonConverter;
import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.entity.ChangeEntity;
import student.enterprise.project.entity.RepeatableChangeEntity;
import student.enterprise.project.entity.SingleChangeEntity;
import student.enterprise.project.repository.SingleChangeRepository;
import student.enterprise.project.repository.RepeatableChangeRepository;
import student.enterprise.project.service.ChangeService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ChangeServiceImpl implements ChangeService {

    private final ModelMapper mapper;
    private SingleChangeRepository singleChangeRepository;
    private RepeatableChangeRepository repeatableChangeRepository;
    private SingleChangeConverter singleChangeConverter;

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
            //TODO implement change entity converter
            return changeDTOList;
        }
        return Collections.emptyList();
    }

    public ChangeDTO findById(Long id) {
        SingleChangeEntity singleChangeEntity = singleChangeRepository.findById(id).orElseThrow(() -> new NullPointerException());
        return singleChangeConverter.toDto(singleChangeEntity);
    }

    public ChangeDTO save(ChangeDTO changeDTO) {
        SingleChangeEntity singleChangeEntity = singleChangeRepository.save(singleChangeConverter.toEntity(changeDTO));
        return singleChangeConverter.toDto(singleChangeEntity);
    }

    //public void update(ChangeDTO changeDTO) {
    //
    //}

    public boolean delete(Long id) {
        if (!singleChangeRepository.findById(id).isPresent()) {
            return false;
        } else {
            singleChangeRepository.deleteById(id);
            return true;
        }
    }

    public List<ChangeDTO> getAll() {
        List<SingleChangeEntity> userEntityList = singleChangeRepository.findAll();
        return singleChangeConverter.toDto(userEntityList);
    }
}
