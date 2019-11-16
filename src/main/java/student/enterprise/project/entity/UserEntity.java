package student.enterprise.project.entity;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.*;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
  User entity
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private List<UserGroupEntity> groupRoleList;

  private String login;

  @Email
  private String email;

  @Column(name = "password")
  private UserPassword password;

  public List<GroupEntity> getGroupList(){
    return groupRoleList.stream()
        .map(UserGroupEntity::getGroup)
        .collect(Collectors.toList());
  }

}
