package student.enterprise.project.entity.rozkladKPI;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kpi_lessons")
public class RozkladLessonEntity {

	@Id
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "number")
	private int number;

	@Column(name = "type")
	private String type;

	@Column(name = "time_start")
	private LocalTime timeStart;

	@Column(name = "time_end")
	private LocalTime timeEnd;

	@OneToOne
	@JoinColumn(name = "teacher", referencedColumnName = "id")
	private RozkladTeacherEntity teacher;

	@OneToOne
	@JoinColumn(name = "room", referencedColumnName = "id")
	private RozkladRoomEntity room;

}
