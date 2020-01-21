package student.enterprise.project.controller;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import student.enterprise.project.dto.ChangeDTO;
import student.enterprise.project.service.impl.ChangeServiceImpl;

import java.util.List;

@RestController
public class ChangeController {
    ChangeServiceImpl changeService = new ChangeServiceImpl(new ModelMapper());

    @GetMapping("/change/{id}")
    ChangeDTO getChange(Long id) {
        return changeService.findById(id);
    }

    @PutMapping("/change/{id}")
    ChangeDTO createChange(@RequestBody ChangeDTO newChangeDTO) {
        return changeService.save(newChangeDTO);
    }

    //@PutMapping("/change/{id}")
    //void updateChange(@RequestBody ChangeDTO updatedChangeDTO) {
    //    changeService.update(updatedChangeDTO);
    //}

    @DeleteMapping("/change/{id}")
    boolean deleteChange(Long id) {
        return changeService.delete(id);
    }

    @GetMapping
    List<ChangeDTO> getAll() {
        return changeService.getAll();
    }

}
