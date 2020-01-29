package student.enterprise.project.entity.rozkladKPI;

import javax.persistence.Column;
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
@Table(name = "kpi_weeks")
public class KpiWeekEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "week_number")
	private int weekNumber;

	@OneToOne
	@JoinColumn(name = "day1_id", referencedColumnName = "id")
	private KpiDayEntity day1;

	@OneToOne
	@JoinColumn(name = "day2_id", referencedColumnName = "id")
	private KpiDayEntity day2;

	@OneToOne
	@JoinColumn(name = "day3_id", referencedColumnName = "id")
	private KpiDayEntity day3;

	@OneToOne
	@JoinColumn(name = "day4_id", referencedColumnName = "id")
	private KpiDayEntity day4;

	@OneToOne
	@JoinColumn(name = "day5_id", referencedColumnName = "id")
	private KpiDayEntity day5;

	@OneToOne
	@JoinColumn(name = "day6_id", referencedColumnName = "id")
	private KpiDayEntity day6;

}
