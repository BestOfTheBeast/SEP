package student.enterprise.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import student.enterprise.project.dto.enums.LecturerDegree;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class LecturerDTO {

	private Long id;

	private List<ChangeDTO> lessonList;

	private String name;

	private String surname;

	private String secondName;

	private LecturerDegree degree;

	public LecturerDTO() {

	}

	public LecturerDTO(Long id, String name, String surname, String secondName, String degree) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.secondName = secondName;

		LecturerDegree ld = null;
		switch (degree) {
		case "��������":
			ld = LecturerDegree.PROFESSOR;
			break;
		case "������":
			ld = LecturerDegree.DOCENT;
			break;
		case "��������":
			ld = LecturerDegree.ASSISTANT;
			break;
		case "������� ��������":
			ld = LecturerDegree.ELDERTEACHER;
			break;
		case "��������":
			ld = LecturerDegree.TEACHER;
			break;
		default:
			ld = LecturerDegree.TEACHER;
			break;
		}

		this.degree = ld;
	}


	public void setDegree(String degree) {
		LecturerDegree ld = null;
		switch (degree) {
		case "��������":
			ld = LecturerDegree.PROFESSOR;
			break;
		case "������":
			ld = LecturerDegree.DOCENT;
			break;
		case "��������":
			ld = LecturerDegree.ASSISTANT;
			break;
		case "������� ��������":
			ld = LecturerDegree.ELDERTEACHER;
			break;
		case "��������":
			ld = LecturerDegree.TEACHER;
			break;
		default:
			ld = LecturerDegree.TEACHER;
			break;
		}
		this.degree = ld;
	}


	
	

}