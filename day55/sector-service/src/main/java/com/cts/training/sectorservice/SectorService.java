package com.cts.training.sectorservice;

import java.util.List;

public interface SectorService {
	public Sector insert(Sector sector);
	public void delete(int id);
	public Sector update(Sector sector);
	public Sector getSectorById(int id);
	public List<Sector> getAllSectors();

}
