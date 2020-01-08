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

  @GetMapping("{id}")
  UserDTO get(@PathVariable Long userId)  { return userService.findById(userId); }

  @DeleteMapping("{id}")
  void deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
  }

  @PutMapping
  UserDTO updateUser(@RequestBody UserDTO userToUpdate) { return userService.updateUser(userToUpdate); }

  @PostMapping("{id}")
  void create(@RequestBody UserDTO newUserDTO){ userService.save(newUserDTO); }

  @GetMapping
  List<UserDTO> getAll() {
    return userService.getAll();
  }
}
