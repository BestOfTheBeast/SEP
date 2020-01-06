package student.enterprise.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import student.enterprise.project.dto.UserDTO;
import student.enterprise.project.service.impl.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping
  UserDTO get(long userId) {
    return userService.findById(userId);
  }

  @DeleteMapping("/user/{id}")
  void deleteEmployee(@PathVariable Long id) {
    userService.deleteUser(id);
  }

  @PutMapping("/users/{id}")
  UserDTO putUser(@RequestBody UserDTO newUserDTO, @PathVariable Long id) {

    return userService.findById(id);
  }
}
