package student.enterprise.project.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import student.enterprise.project.controller.CRUDController;
import student.enterprise.project.dto.UserDTO;
import student.enterprise.project.service.impl.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController implements CRUDController<UserDTO> {

  private final UserService userService;

  @Override
  public UserDTO get(Long id)  {
    return userService.findById(id);
  }

  @Override
  public void delete(@PathVariable Long id) {
    userService.deleteUser(id);
  }

  @Override
  public UserDTO update(@RequestBody UserDTO userToUpdate) { return userService.updateUser(userToUpdate); }

  @Override
  public UserDTO create(@RequestBody UserDTO newUserDTO){ return userService.save(newUserDTO); }

  @Override
  public List<UserDTO> getAll() {
    return userService.getAll();
  }
}
