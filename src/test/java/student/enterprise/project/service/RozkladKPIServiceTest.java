package student.enterprise.project.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import student.enterprise.project.dto.rozkladKPI.ResponseKpiDTO;

import java.io.IOException;

public class RozkladKPIServiceTest {

    @Test
    public void getGroupTest() throws IOException {
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> responseEntity = template.getForEntity("https://api.rozklad.org.ua/v2/groups/ia-83/timetable", String.class);
        JsonNode jsonObject = new ObjectMapper().readTree(responseEntity.getBody());
        ResponseKpiDTO responseObject = template.getForObject("https://api.rozklad.org.ua/v2/groups/ia-83/timetable", ResponseKpiDTO.class);
//        JSONObject jsonObject = new JSONObject(responseEntity);
    }

}
