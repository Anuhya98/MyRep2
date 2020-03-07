package com.cts.training.companyservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name="initial-public-offering-service")
@FeignClient("netflix-zuul-api-gateway-server")
public interface InitialPublicOfferingServiceProxy {
	
	@GetMapping("/initial-public-offering-service/ipo")
	public List<InitialPublicOffering> findAll();

}
