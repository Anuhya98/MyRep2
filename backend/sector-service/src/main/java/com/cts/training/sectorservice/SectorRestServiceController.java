package com.cts.training.sectorservice;

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

@CrossOrigin(origins = "*")
@RestController
public class SectorRestServiceController {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SectorService sectorService;
	
	@GetMapping("/sector")
	public List<Sector> findAll() {
		return sectorService.getAllSectors();
	}
	
	@GetMapping("/sector/{id}")
	public Sector getSectorById(@PathVariable int id) throws NoSuchElementException
	{
	   Sector sectorList=sectorService.getSectorById(id);
		return sectorList;
	}
	
	@PostMapping("/sector")
	public Sector save(@RequestBody Sector sector) {
		Sector newSector=sectorService.insert(sector);
		return newSector;
	}
	
	@DeleteMapping("/sector/{id}")
	public void delete(@PathVariable int id) {
		sectorService.delete(id);
	}
	
	@PutMapping("/updatesector")
	public Sector update(@RequestBody Sector sector) {
		Sector updateSector=sectorService.update(sector);
		return updateSector;
	}

}
