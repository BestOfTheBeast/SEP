package student.enterprise.project.dto.rozkladKPI;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RozkladKpiGroupDTO {

    private Long group_id;

    private String group_full_name;

    private String group_prefix;

    private String group_okr;

    private String group_type;

    private String group_url;

}
