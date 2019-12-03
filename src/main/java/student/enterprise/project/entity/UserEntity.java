package student.enterprise.project.entity;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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

  @Column(name = "login")
  private String login;

  @OneToOne
  @JoinColumn(name = "id", referencedColumnName = "password_id")
  private UserPassword password;

  public List<GroupEntity> getGroupList() {
    return groupRoleList.stream()
        .map(UserGroupEntity::getGroup)
        .collect(Collectors.toList());
  }

}
