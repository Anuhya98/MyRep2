package com.cts.training.userservice;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.userservice.UserDTO;
import com.cts.training.userservice.User;
import com.cts.training.userservice.UserRepo;
import com.cts.training.userservice.UserService;

@CrossOrigin(origins="*")
@RestController
public class UserRestServiceController {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	JavaMailSender jms;
	
	@GetMapping("/login")
	public ResponseEntity<?> login(HttpServletRequest request){
		String authorization=request.getHeader("Authorization");
		logger.info("Login attempt with token -->{}",authorization);
		String username=null;
		String password=null;
		if(authorization !=null && authorization.startsWith("Basic")) {
			String base64Credentials = authorization.substring("Basic".length()).trim();
			byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
			String credentials=new String(credDecoded,StandardCharsets.UTF_8);
			username=credentials.split(":")[0];
			password=credentials.split(":")[1];
		}
		try {
			UserDTO userDTO=userService.getUserByUsernameAndPassword(username,password);
			logger.info("User logged in using username -->{}",username);
			return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
			logger.info("Unauthorized access Stack Trace -->{}",e.getStackTrace().toString());
			return new ResponseEntity<String>("No user found",HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable int id) {
		userRepo.deleteById(id);
	}
	
	@RequestMapping(value="/users/reg",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public String reg() {
		
		return "{\"users\":\"ok\"}";
	}
	
	@PutMapping(value="/users")
	public UserDTO update(@RequestBody UserDTO ud) {
		UserDTO userDTO=userService.update(ud);
		return userDTO;
		
	}
	
	@PutMapping(value="/users/activate")
	public String updateEmail(@RequestBody String e)
	{
		String temp = e.split(":")[1];
		String email=temp.split("\"")[1];
		User user = userRepo.findByEmail(email);
		if(user.getActive().equals("no")) {
			user.setActive("yes");
			userRepo.save(user);
			return "{\"result\":\"1\"}";
		}
		else
		return "{\"result\":\"0\"}";
	}

	@GetMapping(value="/users")
	public ResponseEntity<?> getAllUsers(){
		List<UserDTO> list=userService.getAllUsers();
		if(list.size()>0) {
			return new ResponseEntity<List<UserDTO>>(list,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String> ("No users found",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping(value="/users/{id}",produces="application/json")
	public ResponseEntity<?> getUserById(@PathVariable("id") int id)
	{
		try {
			UserDTO user=userService.getUserById(id);
			return new ResponseEntity<UserDTO> (user,HttpStatus.OK);
			
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<String>("No such user found",HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	@RequestMapping(value="/users",method=RequestMethod.POST)
	public String save(@RequestBody UserDTO userdto){
		UserDTO user;
		String usermail;
		try {
			SimpleMailMessage sm=new SimpleMailMessage();
			sm.setFrom("anuhya1898@gmail.com");
			sm.setTo(userdto.getEmail());
			usermail=userdto.getEmail();
			if(userRepo.findByEmail(usermail)!=null) {
				return "{\"res\":\"0\"}";
				}
			else {
				user=userService.insert(userdto);
				sm.setSubject("testing mail...");
				sm.setText("Account created click on 'http://localhost:4200/activate?" + user.getEmail()
						+ "'");
				jms.send(sm);
				System.out.println("sending mail...");
				return "{\"res\":\"1\"}";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return "{\"res\":\"2\"}";
		}
			
		}
			
		
		}
	
	
	



