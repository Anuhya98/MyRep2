package com.cts.training.companyservice;

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
public class CompanyRestServiceController {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	CompanyRepo companyRepo;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	InitialPublicOfferingServiceProxy proxy;
	
	@GetMapping("/company")
	public ResponseEntity<?>getallcompanies() {
		List<Company> list = companyService.getAllCompanies();
		if(list.size()>0)
		{
			return new ResponseEntity<List<Company>>(list , HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("No companies found",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/company/{id}")
	public ResponseEntity<?> getElementById(@PathVariable("id") int id) {
		try {
			Company company=companyService.getCompanyById(id);
			return new ResponseEntity<Company>(company,HttpStatus.OK);
		}catch(NoClassDefFoundError e){
			return new ResponseEntity<String>("No such company found",HttpStatus.NOT_FOUND);
		}
	}
	

	
	@PostMapping("/company")
	public ResponseEntity<Company> save(@RequestBody Company cmp) {
		companyService.insert(cmp);
		return new ResponseEntity<Company>(cmp,HttpStatus.OK);
	}
	
	@DeleteMapping("/company/{id}")
	public ResponseEntity<Company> delete(@PathVariable int id) {
		companyService.delete(id);
		return new ResponseEntity<Company>(HttpStatus.OK);
	}
	
	@PutMapping("/company")
	public ResponseEntity<Company> update(@RequestBody Company cmp) {
		companyService.update(cmp);
		return new ResponseEntity<Company>(HttpStatus.OK);
	}
	
	@GetMapping(value="ipos-by-company",produces="application/json")
	public List<InitialPublicOffering> getAllIPOs()
	{
		logger.info("Get All users invoked...");
		List<InitialPublicOffering> ipos=proxy.findAll();
		logger.info("Information --> {}",ipos);
		//return proxy.findAll();
		return ipos;
	}

}
