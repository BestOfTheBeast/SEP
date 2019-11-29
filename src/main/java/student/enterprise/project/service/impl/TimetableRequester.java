package student.enterprise.project.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.client.RestTemplate;
import student.enterprise.project.dto.rozkladKPI.KpiGroupDTO;
import student.enterprise.project.dto.rozkladKPI.KpiGroupResponse;
import student.enterprise.project.dto.rozkladKPI.KpiTimetableDTO;
import student.enterprise.project.dto.rozkladKPI.ResponseKpiDTO;
import student.enterprise.project.service.RozkladKPI;

public class TimetableRequester implements RozkladKPI {

	private static TimetableRequester instance;
	
	private TimetableRequester() {
		
	}
	
	public static TimetableRequester get() {
		if(instance == null) {
			instance = new TimetableRequester();
		}
		return instance;
	}
	
	
	@Override
	public KpiTimetableDTO getGroupTimetable(String groupName) {
		String url = "https://api.rozklad.org.ua/v2/groups/" + groupName + "/timetable";
		return getByUrl(url).getData();
	}

	@Override
	public KpiTimetableDTO getGroupTimetable(Long groupId) {
		String uri = "https://api.rozklad.org.ua/v2/groups/" + groupId.toString() + "/timetable";
		return getByUrl(uri).getData();
	}

	@Override
	public List<KpiGroupDTO> getAllGroups() {
		List<KpiGroupDTO> result = new ArrayList<>();
		String uri = "https://api.rozklad.org.ua/v2/groups/?filter= {data}";
		String data = "\"limit\":1,\"offset\":0";
		int numberOfGroups = getNumberOfGroups(uri, data);
		int placeInNumber=4;
		for(int i=placeInNumber; i<=numberOfGroups; i+=100) {
			result.addAll(getGroups(i));
		}
		return result;
	}

	private int getNumberOfGroups(String uri, String data) {
		KpiGroupResponse responseObject = new KpiGroupResponse();
		RestTemplate template = new RestTemplate();
		responseObject = template.getForObject(uri, KpiGroupResponse.class, data);
		return responseObject.getMeta().get("total_count").asInt();
	}
	
	private List<KpiGroupDTO> getGroups(int offset){
		KpiGroupResponse responseObject = new KpiGroupResponse();
		RestTemplate template = new RestTemplate();
		String uri = "https://api.rozklad.org.ua/v2/groups/?filter= {data}";
		String data = "{\"limit\":100,\"offset\":"+offset+"}";
		responseObject = template.getForObject(uri, KpiGroupResponse.class, data);
		return responseObject.getData();
	}

	private ResponseKpiDTO getByUrl(String url) {
		ResponseKpiDTO responseObject = new ResponseKpiDTO();
		RestTemplate template = new RestTemplate();
		responseObject = template.getForObject(url, ResponseKpiDTO.class);
		return responseObject;
	}

}
