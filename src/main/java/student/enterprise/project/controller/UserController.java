package student.enterprise.project.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import student.enterprise.project.dto.UserDTO;
import student.enterprise.project.service.impl.UserService;

public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  UserDTO get(long userId) {
    return userService.getUser(userId);
  }

  @DeleteMapping("/user/{id}")
  void deleteEmployee(@PathVariable Long id) {
    userService.deleteUser(id);
  }

  //TODO move logic to service
  @PutMapping("/users/{id}")
  UserDTO putUser(@RequestBody UserDTO newUserDTO, @PathVariable Long id) {

//    return userService.findById(id)
//        .map(user -> {
//          user.setId(newUserDTO.getId());
//          user.setLogin(newUserDTO.getLogin());
//          user.getGroupList(newUserDTO.getGroupList());
//          return userService.save(user);
//        })
//        .orElseGet(() -> {
//          newUserDTO.setId(id);
//          return userService.save(newUserDTO);
//        });

    return null;
  }
}
