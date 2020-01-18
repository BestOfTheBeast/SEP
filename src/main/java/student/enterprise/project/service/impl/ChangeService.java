package student.enterprise.project.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.service.CRUDService;

import java.util.List;

@RequiredArgsConstructor
public class ChangeService implements CRUDService<ChangeDTO> {

    private final ModelMapper mapper;

    @Override
    public ChangeDTO create(ChangeDTO changeDTO) {
        //TODO implement service method
        return null;
    }

    @Override
    public ChangeDTO get(Long id) {
        //TODO implement service method
        return null;
    }

    @Override
    public List<ChangeDTO> getAll() {
        //TODO implement service method
        return null;
    }

    @Override
    public ChangeDTO update(ChangeDTO changeDTO) {
        //TODO implement service method
        return null;
    }

    @Override
    public void delete(Long id) {
        //TODO implement service method
    }
}
