package com.cts.training.sectorservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectorServiceImpl implements SectorService{
	@Autowired
	SectorRepo sectorRepo;

	@Override
	public Sector insert(Sector sector) {
		Sector sec=sectorRepo.save(sector);
		return sec;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		sectorRepo.deleteById(id);
		
	}

	@Override
	public Sector update(Sector sector) {
		Sector sec=sectorRepo.save(sector);
		return sec;
	}

	@Override
	public Sector getSectorById(int id) {
		Optional<Sector> sectorList=sectorRepo.findById(id);
		Sector sec=sectorList.get();
		return sec;
	}

	@Override
	public List<Sector> getAllSectors() {
		return sectorRepo.findAll();
	}
	

}
