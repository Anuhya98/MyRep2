package com.cts.training.companyservice;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes=CompanyServiceApplication.class,webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class CompanyControllerIT {
	@LocalServerPort
	private int port;
	HttpHeaders headers=new HttpHeaders();
	TestRestTemplate restTemplate=new TestRestTemplate();
	
	@Test
	void getTest() {
		String url="http://localhost:"+port+"/company";
		System.out.println("Port::"+url);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<String>(null,headers);
		ResponseEntity<String> response=restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
		String expected=" {\"id\": 109,\r\n" + 
				"        \"username\": \"anu\",\r\n" + 
				"        \"email\": \"anu@gmail.com\",\r\n" + 
				"        \"phoneno\": 9876543,\r\n" + 
				"        \"password\": \"anuhya\",\r\n" + 
				"        \"confirmpassword\": \"anuhya\"}";
		System.out.println("TEST::Response Body:::"+response.getBody());
	}
	

}
