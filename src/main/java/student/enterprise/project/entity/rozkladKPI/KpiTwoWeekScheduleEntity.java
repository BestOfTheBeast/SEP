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

/*
Two Week Schedule entity
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kpi_two_week_schedules")
public class KpiTwoWeekScheduleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "first_week_id", referencedColumnName = "id")
	private KpiWeekEntity first_week;

	@OneToOne
	@JoinColumn(name = "second_week_id", referencedColumnName = "id")
	private KpiWeekEntity second_week;

}
