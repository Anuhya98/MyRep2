package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestServiceContoller 
{
	@Autowired
	ProductRepo pr;
	@RequestMapping(value="/prod",method=RequestMethod.GET,produces=MediaType.APPLICATION_XML_VALUE)
	public List<Product> findAll(){
		return pr.findAll();
	}
	
	@RequestMapping(value="/prod/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_XML_VALUE)
	public Product findOne(@PathVariable int id) {
		Optional<Product> pro=pr.findById(id);
		Product p=pro.get();
		return p;
	}
	
	@RequestMapping(value="/prod",method=RequestMethod.POST)
	public Product save(@RequestBody Product pro) {
		Product prod=pr.save(pro);
		return prod;
	}
	
	@RequestMapping(value="/prod/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable int id)
	{
		pr.deleteById(id);
	}
	
	@RequestMapping(value="/prod",method=RequestMethod.PUT)
	public Product update(@RequestBody Product pro) {
		Product prod=pr.save(pro);
		return prod;
	}
	
	

}
