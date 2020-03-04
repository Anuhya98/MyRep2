package com.cts.training.companyservice;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CompanyRestServiceController.class)
public class CompanyRestServiceControllerTest {
	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	CompanyService companyService;
	
	@Test
	public void findAll() throws Exception{
	Company company=new Company(109,"Coldact",8000,"Imraan","others","a","ok");
	List<Company> companyList=new ArrayList<Company>();
	companyList.add(company);
	Mockito.when(companyService.getAllCompanies()).thenReturn(companyList);
	RequestBuilder request=MockMvcRequestBuilders.get("/company").accept(MediaType.APPLICATION_JSON);
	MvcResult result=mockmvc.perform(request).andReturn();
	String expected= "{}";
	assertTrue(result.getResponse().getContentAsString().contains(expected));

	}
}
