
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
@Table(name = "kpi_rooms")
public class RozkladRoomEntity {

	@Id
	private int id;
	
	@Column(name = "name")
	private String name;
	
}
