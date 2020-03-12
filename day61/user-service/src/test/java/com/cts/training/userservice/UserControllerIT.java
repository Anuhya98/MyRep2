package com.cts.training.userservice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;
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

@SpringBootTest(classes=UserServiceApplication.class,webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class UserControllerIT {
	@LocalServerPort
	private int port;
	HttpHeaders headers=new HttpHeaders();
	TestRestTemplate restTemplate=new TestRestTemplate();
	
	@Test
	public void getTest() {
		String url="http://localhost:"+port+"/users";
		System.out.println("Port::"+url);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<String>(null,headers);
		ResponseEntity<String> response=restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
		String expected="{\"id\":27,\"username\":\"anu\",\"email\":\"anu@gmail.com\",\"phoneno\":9876543,\"password\":\"anuhya\",\"confirmpassword\":\"anuhya\"}";
		System.out.println("TEST::Response Body:::"+response.getBody());
		assertTrue(response.getBody().contains(expected));
	}
	
	@Test
	public void getbyIdtest() {
		String url="http://localhost:"+port+"/users/27";
		System.out.println("Port::"+url);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<String>(null,headers);
		ResponseEntity<String> response=restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
		String expected="{\"id\":27,\"username\":\"anu\",\"email\":\"anu@gmail.com\",\"phoneno\":9876543,\"password\":\"anuhya\",\"confirmpassword\":\"anuhya\"}";
		System.out.println("TEST::Response Body:::"+response.getBody());
		assertTrue(response.getBody().contains(expected));
	}
	
	@Test
	public void addUserTest() {
		String url="http://localhost:"+port+"/users";
		System.out.println("Port::"+url);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		User user=new User(100, "Ramya", "rams@gma.com", 685434, "ramya", "ramya", null, "no", null);
		HttpEntity<User> entity=new HttpEntity<User>(user,headers);
		ResponseEntity<String> response=restTemplate.exchange(url, HttpMethod.POST,entity,String.class);
	    String expected="\"username\":\"Ramya\",\"email\":\"rams@gma.com\",\"phoneno\":685434,\"password\":\"ramya\",\"confirmpassword\":\"ramya\"}";
		System.out.println("TEST::Response Body:::"+response.getBody());
		assertTrue(response.getBody().contains(expected));
	}



}
