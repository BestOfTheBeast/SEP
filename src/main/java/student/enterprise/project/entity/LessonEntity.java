package student.enterprise.project.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import student.enterprise.project.converter.jpa.LocalDateAttributeConverter;

/*
  Enum entity that defines lesson order number and it's time
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lessons")
public class  LessonEntity{

  @Id
  private Long id;

  //Lesson time of day
  @Convert(converter = LocalDateAttributeConverter.class)
  @Column(name = "time", columnDefinition = "TIME")
  private LocalTime time;

  //Lesson order number
  @Column(name = "number")
  private Integer number;

}
