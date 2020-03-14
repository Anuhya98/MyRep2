package com.cts.training.initialpublicofferingservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitialPublicOfferingServiceImpl implements InitialPublicOfferingService{

	@Autowired
	InitialPublicOfferingRepo ipoRepo;
	
	@Override
	public InitialPublicOffering insert(InitialPublicOffering ipo) {
		InitialPublicOffering ipo1=ipoRepo.save(ipo);
		return ipo1;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		ipoRepo.deleteById(id);
		
	}

	@Override
	public InitialPublicOffering update(InitialPublicOffering ipo) {
		InitialPublicOffering ipo1=ipoRepo.save(ipo);
		return ipo1;
	}

	@Override
	public InitialPublicOffering getIpoById(int id) {
		Optional<InitialPublicOffering> ipoList=ipoRepo.findById(id);
		InitialPublicOffering ipo1=ipoList.get();
		return ipo1;
	}

	@Override
	public List<InitialPublicOffering> getAllIpos() {
		return ipoRepo.findAll();
	}

}
