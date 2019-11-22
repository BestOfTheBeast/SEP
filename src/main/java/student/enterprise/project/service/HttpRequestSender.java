package student.enterprise.project.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import springfox.documentation.spring.web.json.Json;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class HttpRequestSender {
	private static HttpRequestSender httpRequestSender;
	private CloseableHttpClient httpClient; 
	private HttpRequestSender() {
		this.httpClient = HttpClients.createDefault();
	}
	public static HttpRequestSender get() {
		if(httpRequestSender == null) {
			httpRequestSender = new HttpRequestSender();
		}
		return httpRequestSender;
	}
	
	
	
	public JSONObject sendGet(String uri) {
		//create default JSONObject to store response;
		JSONObject JSONresponse = new JSONObject();
		try {
			//create Http Get Request Object
			HttpGet request = new HttpGet(uri);
			//execute Http Request and store result in Http Response Object
			CloseableHttpResponse response = this.httpClient.execute(request);
			try {
				//create parser and parse Http Response Body to JSONPbject
				JSONParser parser = new JSONParser();
				JSONresponse = (JSONObject) parser.parse(new BasicResponseHandler().handleResponse(response));
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}finally {
				response.close();	
			}
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return JSONresponse;
	}
	
	public JSONObject sendGet(String uri, List<Header> headers) {
		//create default JSONObject to store response;
				JSONObject JSONresponse = new JSONObject();
				try {
					//create Http Get Request Object
					HttpGet request = new HttpGet(uri);
					//set all headers
					for(Header header : headers) {
						request.setHeader(header);
					}
					//execute Http Request and store result in Http Response Object
					CloseableHttpResponse response = this.httpClient.execute(request);
					try {
						//create parser and parse Http Response Body to JSONPbject
						JSONParser parser = new JSONParser();
						JSONresponse = (JSONObject) parser.parse(new BasicResponseHandler().handleResponse(response));
					}catch(Exception e){
						e.printStackTrace();
						return null;
					}finally {
						response.close();	
					}
				}catch(IOException e) {
					e.printStackTrace();
					return null;
				}
				
				return JSONresponse;
	}
	//TODO implement POST request if needed in future
	
	public boolean close() {
		try {
			this.httpClient.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
