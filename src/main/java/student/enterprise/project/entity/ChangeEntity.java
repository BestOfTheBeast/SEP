package student.enterprise.project.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import lombok.Data;

/*
  Change entity that contains one change for one specific lesson.
  TODO May be shared
 */
@Data
@MappedSuperclass
public abstract class ChangeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "lesson_id", referencedColumnName = "id")
  private LessonEntity lessonEntity;

  @ManyToOne
  @JoinColumn(name = "subject_id", referencedColumnName = "id")
  private SubjectEntity subjectEntity;

  @ManyToOne
  @JoinColumn(name = "lecturer_id", referencedColumnName = "id")
  private LecturerEntity lecturerEntity;

}
