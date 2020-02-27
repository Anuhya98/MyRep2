package com.example.demo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class RestResource {
	@Value("${welcome.msg}")
	String welcomemsg;
	@GetMapping("/msg")
	public String getmsg()
	{
		return welcomemsg;
	}
}



