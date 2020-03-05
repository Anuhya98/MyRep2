package com.cts.training.companyservice;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class CompanyRestServiceController {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	CompanyRepo companyRepo;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	InitialPublicOfferingServiceProxy proxy;
	
	@GetMapping("/company")
	public List<Company> findAll() {
		return companyService.getAllCompanies();
	}
	
	@GetMapping("/company/{id}")
	public Company getCompanyById(@PathVariable int id) throws NoSuchElementException
	{
		Company companyList=companyService.getCompanyById(id);
		return companyList;
	}
	
//	@GetMapping("/company/{id}")
//	public Company findOne(@PathVariable int id) {
//		Optional<Company> cmp = cr.findById(id);
//		Company c = cmp.get();
//		return c;
//	}
	
	@PostMapping("/company")
	public Company save(@RequestBody Company cmp) {
		Company newCompany=companyService.insert(cmp);
		return newCompany;
	}
	
	@DeleteMapping("/company/{id}")
	public void delete(@PathVariable int id) {
		companyService.delete(id);
	}
	
	@PutMapping("/updatecompany")
	public Company update(@RequestBody Company cmp) {
		Company updateCompany=companyService.update(cmp);
		return updateCompany;
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
