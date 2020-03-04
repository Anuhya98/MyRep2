package com.cts.training.userservice;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
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
	@Autowired
	UserRepo ur;
	
	@Autowired
	UserService userService;
	
	@Autowired
	JavaMailSender jms;
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable int id) {
		ur.deleteById(id);
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
			if(ur.findByEmail(usermail)!=null) {
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
	
	
	



