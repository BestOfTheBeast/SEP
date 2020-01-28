package student.enterprise.project.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import student.enterprise.project.converter.impl.LessonConverter;
import student.enterprise.project.converter.impl.SingleChangeConverter;
import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.entity.SingleChangeEntity;
import student.enterprise.project.repository.LecturerRepository;
import student.enterprise.project.repository.RepeatableChangeRepository;
import student.enterprise.project.repository.SingleChangeRepository;
import student.enterprise.project.repository.SubjectRepository;
import student.enterprise.project.service.CRUDService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChangeService implements CRUDService<ChangeDTO> {

    private final ModelMapper mapper;
    private SingleChangeRepository singleChangeRepository;
    private RepeatableChangeRepository repeatableChangeRepository;
    private SingleChangeConverter singleChangeConverter;
    private SubjectRepository subjectRepository;
    private LecturerRepository lecturerRepository;
    private LessonConverter lessonConverter;

    @Override
    public ChangeDTO create(ChangeDTO changeDTO) {
        SingleChangeEntity singleChangeEntity = singleChangeRepository.save(singleChangeConverter.toEntity(changeDTO));
        return singleChangeConverter.toDto(singleChangeEntity);
    }

    @Override
    public ChangeDTO get(long id) {
        SingleChangeEntity singleChangeEntity = singleChangeRepository.findById(id).orElseThrow(() -> new NullPointerException());
        return singleChangeConverter.toDto(singleChangeEntity);
    }

    @Override
    public List<ChangeDTO> getAll() {
        List<SingleChangeEntity> userEntityList = singleChangeRepository.findAll();
        return singleChangeConverter.toDto(userEntityList);
    }

    @Override
    public ChangeDTO update(ChangeDTO changeDTO) {
        SingleChangeEntity changeEntity = singleChangeRepository.getOne(changeDTO.getId());
        changeEntity.setLessonEntity(lessonConverter.toEntity(changeDTO.getLessonDTO()));
        changeEntity.setSubjectEntity(subjectRepository.getOne(changeDTO.getSubjectId()));
        changeEntity.setLecturerEntity(lecturerRepository.getOne(changeDTO.getLecturerId()));
        singleChangeRepository.save(changeEntity);
        return singleChangeConverter.toDto(changeEntity);
    }

    @Override
    public void delete(long id) {
        if (!singleChangeRepository.findById(id).isPresent()) {
            singleChangeRepository.deleteById(id);
        }
    }
}
