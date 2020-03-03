package com.cts.training.initialpublicofferingservice;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	InitialPublicOfferingService ipoService;
	
	@GetMapping("/ipo")
	public List<InitialPublicOffering> findAll() {
		return ipoService.getAllIpos();
	}
	
	@GetMapping("/ipo/{id}")
	public InitialPublicOffering getIpoById(@PathVariable int id) throws NoSuchElementException
	{
		InitialPublicOffering ipoList=ipoService.getIpoById(id);
		return ipoList;
	}
	@PostMapping("/ipo")
	public InitialPublicOffering save(@RequestBody InitialPublicOffering ipo) {
		InitialPublicOffering newIpo=ipoService.insert(ipo);
		return newIpo;
	}
	
	@DeleteMapping("/ipo/{id}")
	public void delete(@PathVariable int id) {
		ipoService.delete(id);
	}
	
	@PutMapping("/updateipo")
	public InitialPublicOffering update(@RequestBody InitialPublicOffering ipo) {
		InitialPublicOffering updateIpo=ipoService.update(ipo);
		return updateIpo;
	}

}
