package student.enterprise.project.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import student.enterprise.project.controller.CRUDController;
import student.enterprise.project.dto.GroupDTO;
import student.enterprise.project.service.impl.GroupService;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/groups")
public class GroupController implements CRUDController<GroupDTO> {
    private final GroupService groupService ;

    @Override
    public GroupDTO create(@RequestBody GroupDTO groupDTO ){
        return groupService.create(groupDTO);
    }

    @Override
    public List<GroupDTO> getAll() {
        return groupService.getAll();
    }

    @Override
    public GroupDTO get(@PathVariable Long id){
        return groupService.get(id);
    }

    @Override
    public void delete(Long id) {
         groupService.delete(id);
    }

    @Override
    public GroupDTO update(@RequestBody GroupDTO groupDTO){
        return groupService.update(groupDTO);
    }
}
