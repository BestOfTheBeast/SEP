package student.enterprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import student.enterprise.project.dto.GroupDefaultSchedule;
import student.enterprise.project.service.RozkladController;

@SpringBootApplication
public class SepApplication {

	public static void main(String[] args) {
		SpringApplication.run(SepApplication.class, args);
		
		RozkladController rc = new RozkladController();
		
		GroupDefaultSchedule gds = rc.getDefaultGroup("³ò-81");
		
		gds.printSchedule();
		
	}

}
