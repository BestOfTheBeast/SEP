package com.student.enterprise.project.entity;

import com.student.enterprise.project.converter.jpa.LocalDateAttributeConverter;
import com.student.enterprise.project.converter.jpa.LocalDateTimeAttributeConverter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
  Change entity that contains one change for one specific lesson.
  TODO May be repeatable
  TODO May be shared
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "changes")
public class ChangeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Convert(converter = LocalDateAttributeConverter.class)
  @Column(name = "date", columnDefinition = "DATE")
  private LocalDate date;

  @ManyToOne
  @JoinColumn(name = "lesson_id", referencedColumnName = "id")
  private LessonEntity lessonEntity;

}
