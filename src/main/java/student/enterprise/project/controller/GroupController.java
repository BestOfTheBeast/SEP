package student.enterprise.project.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import student.enterprise.project.converter.impl.GroupConverter;
import student.enterprise.project.dto.GroupDTO;
import student.enterprise.project.service.impl.GroupService;


@AllArgsConstructor
@RestController
public class GroupController {
    private final GroupService groupService;
    private final   GroupConverter groupConverter;

    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public void insert(GroupDTO groupDTO ){
        groupService.save(groupConverter.toEntity(groupDTO));
    }

    @RequestMapping(value="/get", method = RequestMethod.GET)
    public GroupDTO get(@RequestParam long id){
        return groupService.getGroup(id);
    }

    @RequestMapping(value="/delete", method = RequestMethod.DELETE)
    public boolean  delete(@RequestParam long id){
        return groupService.delete(id);
    }

    @RequestMapping(value="/update", method = RequestMethod.PATCH)
    public boolean update(GroupDTO groupDTO){
        return groupService.update(groupDTO);
    }

}
