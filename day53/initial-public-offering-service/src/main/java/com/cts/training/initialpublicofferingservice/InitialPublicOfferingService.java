package com.cts.training.initialpublicofferingservice;

import java.util.List;



public interface InitialPublicOfferingService {
	public InitialPublicOffering insert(InitialPublicOffering ipo);
	public void delete(int id);
	public InitialPublicOffering update(InitialPublicOffering ipo);
	public InitialPublicOffering getIpoById(int id);
	public List<InitialPublicOffering> getAllIpos();


}
