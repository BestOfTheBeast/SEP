package student.enterprise.project.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import student.enterprise.project.converter.jpa.LocalDateAttributeConverter;

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

  public LocalDateTime getDateTime() {
    return Objects.nonNull(date) && Objects.nonNull(lessonEntity) && Objects.nonNull(lessonEntity.getTime())
        ? LocalDateTime.of(date, lessonEntity.getTime())
        : null;
  }

}
