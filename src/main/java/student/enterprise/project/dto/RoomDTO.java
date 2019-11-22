package student.enterprise.project.dto;

public class RoomDTO {
	Long id;
	
	String room;
	    
	int building;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public int getBuilding() {
		return building;
	}

	public void setBuilding(int building) {
		this.building = building;
	}

	@Override
	public String toString() {
		return "RoomDTO [id=" + id + ", room=" + room + ", building=" + building + "]";
	}
	
	
}
