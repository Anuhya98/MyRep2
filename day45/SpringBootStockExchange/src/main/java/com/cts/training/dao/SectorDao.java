package com.cts.training.dao;

import java.util.List;

import com.cts.training.model.Company;
import com.cts.training.model.Sector;

public interface SectorDao 
{
	public boolean addSector(Sector sector);
	public boolean deleteSector(Sector sector);
	public boolean updateSector(Sector sector);
	public Sector getSectorById(int sectorId);
	public List<Sector> getAllSectors();

}
