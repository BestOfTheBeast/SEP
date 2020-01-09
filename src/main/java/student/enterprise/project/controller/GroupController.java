package student.enterprise.project.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import student.enterprise.project.converter.impl.GroupConverter;
import student.enterprise.project.dto.GroupDTO;
import student.enterprise.project.service.impl.GroupService;


@RequiredArgsConstructor
@RestController
@RequestMapping("groups")
public class GroupController {
    private final GroupService groupService ;

    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public void insert(GroupDTO groupDTO ){
        groupService.save(groupDTO);
    }

    @RequestMapping(value="/get", method = RequestMethod.GET)
    public GroupDTO get(@PathVariable long id){
        return groupService.getGroup(id);
    }

    @RequestMapping(value="/delete", method = RequestMethod.DELETE)
    public boolean  delete(@PathVariable long id){
        return groupService.delete(id);
    }

    @RequestMapping(value="/update", method = RequestMethod.PUT)
    public boolean update(GroupDTO groupDTO){
        return groupService.update(groupDTO);
    }

}
