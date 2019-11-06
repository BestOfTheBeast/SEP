package com.student.enterprise.project.entity;

import com.student.enterprise.project.converter.jpa.LocalDateAttributeConverter;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
  Enum entity that defines lesson order number and it's time
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lessons")
public class LessonEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  //Lesson time of day
  @Convert(converter = LocalDateAttributeConverter.class)
  @Column(name = "time", columnDefinition = "TIME")
  private LocalTime time;

  //Lesson order number
  @Column(name = "number")
  private Integer number;

}
