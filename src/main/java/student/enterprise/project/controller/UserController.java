package student.enterprise.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import student.enterprise.project.dto.UserDTO;
import student.enterprise.project.service.impl.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @GetMapping("/{id}")
  UserDTO get(@PathVariable Long userId)  { return userService.findById(userId); }

  @DeleteMapping("/{id}")
  void delete(@PathVariable Long id) {
    userService.delete(id);
  }

  @PutMapping
  UserDTO update(@RequestBody UserDTO userToUpdate) { return userService.update(userToUpdate); }

  @PostMapping("/{id}")
  UserDTO create(@RequestBody UserDTO newUserDTO){ return userService.create(newUserDTO); }

  @GetMapping
  List<UserDTO> getAll() {
    return userService.getAll();
  }
}
