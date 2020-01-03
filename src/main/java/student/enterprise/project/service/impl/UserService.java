package student.enterprise.project.service.impl;

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

  public UserDTO getUser(long userID) {
    //for( : ) {
    // ..................
    // Цикл, который перебирает объекты
    if (userDTO.getId() == userID) {
      return userDTO;
    }
    return null;
  }

  public void save(UserDTO user) {
    //Сохраняем нашего user в DataBase
  }

  public void findById(UserDTO user) {
    //Находим user
  }

}
