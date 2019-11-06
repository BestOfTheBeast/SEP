package com.student.enterprise.project.entity;

import java.util.List;
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
  Group entity
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "groups")
public class GroupEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "parent_id", referencedColumnName = "id")
  private GroupEntity parentChange;

  @OneToMany
  @JoinColumn(name = "group_id", referencedColumnName = "id")
  private List<UserGroupEntity> userRoleList;

  @OneToMany
  @JoinColumn(name = "group_id", referencedColumnName = "id")
  private List<ChangeEntity> changeList;

}
