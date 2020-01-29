package student.enterprise.project.entity.rozkladKPI;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "kpi_teachers")
public class RozkladTeacherEntity {

	@Id
	private int id;

	@Column(name = "full_name")
	private String teacherNameSurnameSecondname;

}
