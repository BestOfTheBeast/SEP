package student.enterprise.project.service.impl;

import org.springframework.stereotype.Service;
import student.enterprise.project.dto.UserDTO;

@Service
public class UserService {

  UserDTO userDTO;

  public void updateUser(UserDTO user) {
    //Парсим с DataBase в UserDTO
  }

  public void deleteUser(long userID) {
    //for( : ) {
    // ..................
    // Цикл, который перебирает объекты
    if (userDTO.getId() == userID) {

    }
  }

  public void save(UserDTO user) {
    //Сохраняем нашего user в DataBase
  }

  public UserDTO findById(long userID) {

    //for( : ) {
    // ..................
    // Цикл, который перебирает объекты
    if (userDTO.getId().equals(userID)) {
      return userDTO;

    }
    return null;
  }

}
