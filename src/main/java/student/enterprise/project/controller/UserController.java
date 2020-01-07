package student.enterprise.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import student.enterprise.project.dto.UserDTO;
import student.enterprise.project.service.impl.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping
  UserDTO get(long userId) {
    return userService.findById(userId);
  }

  @DeleteMapping("/user/{id}")
  void deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
  }

  @PutMapping("/users/{id}")
  void putUser(@PathVariable Long id) { userService.updateUser(id); }

  @RequestMapping(value = "/insert", method = RequestMethod.POST)
  void insert(UserDTO userDTO) { userService.save(userDTO); }

  @PostMapping("/user/{id}")
  void create(@PathVariable Long id, @PathVariable String login){ userService.create(id, login); }

  @GetMapping
  List<UserDTO> getAll() {
    return userService.getAll();
  }
}
