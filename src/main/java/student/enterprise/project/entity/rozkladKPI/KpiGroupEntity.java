package student.enterprise.project.entity.rozkladKPI;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import student.enterprise.project.entity.rozkladKPI.KpiTimetableEntity.KpiTimetableEntityBuilder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kpi_groups")
public class KpiGroupEntity {

	@Id
	private Long id;
	
	@Column(name = "full_name")
    private String group_full_name;

	@Column(name = "prefix")
    private String group_prefix;

	@Column(name = "okr")
    private String group_okr;

	@Column(name = "type")
    private String group_type;

	@Column(name = "url")
    private String group_url;
	
}
