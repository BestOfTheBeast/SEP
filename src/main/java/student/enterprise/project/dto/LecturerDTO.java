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
		case "професор":
			ld = LecturerDegree.PROFESSOR;
			break;
		case "доцент":
			ld = LecturerDegree.DOCENT;
			break;
		case "асистент":
			ld = LecturerDegree.ASSISTANT;
			break;
		case "старший викладач":
			ld = LecturerDegree.ELDERTEACHER;
			break;
		case "викладач":
			ld = LecturerDegree.TEACHER;
			break;
		default:
			ld = LecturerDegree.TEACHER;
			break;
		}

		this.degree = ld;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public LecturerDegree getDegree() {
		return degree;
	}

	public void setDegree(LecturerDegree degree) {
		this.degree = degree;
	}

	public void setDegree(String degree) {
		LecturerDegree ld = null;
		switch (degree) {
		case "професор":
			ld = LecturerDegree.PROFESSOR;
			break;
		case "доцент":
			ld = LecturerDegree.DOCENT;
			break;
		case "асистент":
			ld = LecturerDegree.ASSISTANT;
			break;
		case "старший викладач":
			ld = LecturerDegree.ELDERTEACHER;
			break;
		case "викладач":
			ld = LecturerDegree.TEACHER;
			break;
		default:
			ld = LecturerDegree.TEACHER;
			break;
		}
		this.degree = ld;
	}

	@Override
	public String toString() {
		return "LecturerDTO [id=" + id + ", lessonList=" + lessonList + ", name=" + name + ", surname=" + surname
				+ ", secondName=" + secondName + ", degree=" + degree + "]";
	}
	
	

}