package student.enterprise.project.service;

import org.junit.Test;
import student.enterprise.project.service.impl.TimetableRequester;
import java.io.IOException;

public class RozkladKPIServiceTest {

    @Test
    public void getGroupTest() throws IOException {
    	TimetableRequester tr = TimetableRequester.get();
    	tr.getAllGroups().forEach(System.out::println);
    }

}