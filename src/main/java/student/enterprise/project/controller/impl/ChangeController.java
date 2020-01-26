package student.enterprise.project.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import student.enterprise.project.controller.CRUDController;
import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.service.impl.ChangeService;


import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/changes")
public class ChangeController implements CRUDController<ChangeDTO> {

    private final ChangeService changeService;

    @Override
    public ChangeDTO get(Long id)  {
        return changeService.get(id);
    }

    @Override
    public void delete(@PathVariable Long id) {
        changeService.delete(id);
    }

    @Override
    public ChangeDTO update(@RequestBody ChangeDTO changeToUpdate) {
        return changeService.update(changeToUpdate);
    }

    @Override
    public ChangeDTO create(@RequestBody ChangeDTO newChangeDTO){
        return changeService.create(newChangeDTO);
    }

    @Override
    public List<ChangeDTO> getAll() {
        return changeService.getAll();
    }
}
