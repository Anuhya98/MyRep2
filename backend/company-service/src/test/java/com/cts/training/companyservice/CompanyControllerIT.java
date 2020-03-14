package com.cts.training.companyservice;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
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
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Test
	void getTest() {
		String url="http://localhost:"+port+"/company";
		System.out.println("Port::"+url);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<String>(null,headers);
		ResponseEntity<String> response=restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
		String expected="{\"id\":134,\"companyname\":\"TCS\",\"turnover\":8500,\"companyceoname\":\"Tata\",\"boardofdirectors\":\"Pavitra\",\"selectstockexchange\":\"nse\",\"selectsector\":\"it\",\"aboutcompany\":\"Indian mnc\"}";
		logger.info("TEST::Response Body:::"+response.getBody());
		assertTrue(response.getBody().contains(expected));
	}
	
	@Test
	public void getbyidtest() throws Exception
	{
		String url="http://localhost:"+port+"/company/134";
		System.out.println("Port is ::"+url);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<String>(null,headers);
		ResponseEntity<String> response=restTemplate.exchange(url,HttpMethod.GET,entity,String.class);
		String expected="{\"id\":134,\"companyname\":\"TCS\",\"turnover\":8500,\"companyceoname\":\"Tata\",\"boardofdirectors\":\"Pavitra\",\"selectstockexchange\":\"nse\",\"selectsector\":\"it\",\"aboutcompany\":\"Indian mnc\"}";
		logger.info("TEST :: Response Body :::: " +response.getBody());
		assertTrue(response.getBody().contains(expected));
		
	}
	
	
//	@Test
//	public void addtest() throws Exception
//	{
//		String url="http://localhost:"+port+"/company";
//		System.out.println("Port is ::"+url);
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		Company company=new Company(150, "Infoview", 2500, "Gupta", "Shukla", "others", "it", "Chennai");
//		HttpEntity<Company> entity=new HttpEntity<Company>(company,headers);
//		ResponseEntity<String> response=restTemplate.exchange(url,HttpMethod.POST,entity,String.class);
//		String expected="\"companyname\":\"Infoview\",\"turnover\":2500,\"companyceoname\":\"Gupta\",\"boardofdirectors\":\"Shukla\",\"selectstockexchange\":\"others\",\"selectsector\":\"it\",\"aboutcompany\":\"Chennai\"}";
//		assertTrue(response.getBody().contains(expected));
//		
//	}
//	
//	@Test
//	public void deletetest() throws Exception{
//		String url="http://localhost:"+port+"/company/147";
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		HttpEntity<Company> entity=new HttpEntity<Company>(null,headers);
//		ResponseEntity<String> response=restTemplate.exchange(url, HttpMethod.DELETE,entity,String.class);
//		System.out.println("Test delete::Response body ::"+response.getBody());
//		assertEquals(HttpStatus.OK,response.getStatusCode());
//	}
//	
	@Test
	public void updatetest() throws Exception
	{
		String url="http://localhost:"+port+"/updatecompany";
		System.out.println("Port is ::"+url);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		Company company=new Company(109, "Coldact", 8000, "Imraan", "Rashmi", "nse", "it", "Pharmacueticals");
		HttpEntity<Company> entity=new HttpEntity<Company>(company,headers);
		ResponseEntity<String> response=restTemplate.exchange(url,HttpMethod.PUT,entity,String.class);
		String expected="{\"id\":109,\"companyname\":\"Coldact\",\"turnover\":8000,\"companyceoname\":\"Imraan\",\"boardofdirectors\":\"Rashmi\",\"selectstockexchange\":\"nse\",\"selectsector\":\"it\",\"aboutcompany\":\"Pharmacueticals\"}";
		logger.info("TEST :: Response Body :::: " +response.getBody());
		assertTrue(response.getBody().contains(expected));
		
	}
	

}
