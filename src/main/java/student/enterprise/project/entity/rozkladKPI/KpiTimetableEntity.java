package student.enterprise.project.entity.rozkladKPI;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "kpi_timetables")
public class KpiTimetableEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "group_id", referencedColumnName = "id")
	private KpiGroupEntity group;

	@OneToOne
	@JoinColumn(name = "timetable_id", referencedColumnName = "id")
	private KpiTwoWeekScheduleEntity weeks;
}
