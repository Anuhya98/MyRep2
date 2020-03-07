package com.cts.training.initialpublicofferingservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
public class InitialPublicOfferingRestServiceController {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	InitialPublicOfferingService ipoService;
	
	@GetMapping("/ipo")
	public ResponseEntity<?>getallipos() {
		List<InitialPublicOffering> list = ipoService.getAllIpos();
		if(list.size()>0)
		{
			return new ResponseEntity<List<InitialPublicOffering>>(list , HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("No ipos found",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/ipo/{id}")
	public ResponseEntity<?> getElementById(@PathVariable("id") int id) {
		try {
			InitialPublicOffering ipo=ipoService.getIpoById(id);
			return new ResponseEntity<InitialPublicOffering>(ipo,HttpStatus.OK);
		}catch(NoClassDefFoundError e){
			return new ResponseEntity<String>("No such ipo found",HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/ipo")
	public ResponseEntity<InitialPublicOffering> save(@RequestBody InitialPublicOffering ipo) {
		ipoService.insert(ipo);
		return new ResponseEntity<InitialPublicOffering>(ipo,HttpStatus.OK);
	}
	
	@DeleteMapping("/ipo/{id}")
	public ResponseEntity<InitialPublicOffering> delete(@PathVariable int id) {
		ipoService.delete(id);
		return new ResponseEntity<InitialPublicOffering>(HttpStatus.OK);
	}
	
	@PutMapping("/updateipo")
	public ResponseEntity<InitialPublicOffering> update(@RequestBody InitialPublicOffering ipo) {
		ipoService.update(ipo);
		return new ResponseEntity<InitialPublicOffering>(HttpStatus.OK);
	}

}
