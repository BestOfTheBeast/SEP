package student.enterprise.project.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import student.enterprise.project.converter.impl.UserConverter;
import student.enterprise.project.dto.UserDTO;
import student.enterprise.project.entity.UserEntity;
import student.enterprise.project.repository.UserRepository;

import javax.xml.ws.http.HTTPException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

  private UserRepository userRepository;
  private UserConverter userConverter;

  public UserDTO update(UserDTO userToUpdate) {
    UserEntity userEntity = userRepository.findById(userToUpdate.getId()).orElseThrow(() -> new HTTPException(404));
    userEntity.setLogin(userToUpdate.getLogin());
    userRepository.save(userEntity);
    return userConverter.toDto(userRepository.save(userEntity));
  }

  public List<UserDTO> getAll() {
    List<UserEntity> userEntityList = userRepository.findAll();
    return userConverter.toDto(userEntityList);
  }

  public void delete(long userID) {
    if (userRepository.findById(userID).isPresent()) {
      throw new HTTPException(404);
    }
    userRepository.deleteById(userID);
  }

  public UserDTO create(UserDTO user) {
    UserEntity userEntity = userRepository.save(userConverter.toEntity(user));
    if (userEntity.equals(null)){
      throw new HTTPException(404);
    }
    return userConverter.toDto(userEntity);
  }

  public UserDTO findById(long userID) {
    UserEntity userEntity = userRepository.findById(userID).orElseThrow(() -> new HTTPException(404));
    return userConverter.toDto(userEntity);
  }

}
