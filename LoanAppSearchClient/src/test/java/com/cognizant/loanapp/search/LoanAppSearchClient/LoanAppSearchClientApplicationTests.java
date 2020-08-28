package com.cognizant.loanapp.search.LoanAppSearchClient;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.loanapp.search.searchclient.repository.SearchRepository;
import com.cognizant.loanapp.search.searchclient.service.SearchServiceImpl;
 
@SpringBootTest
class LoanAppSearchClientApplicationTests {
	
	@Autowired
	private SearchServiceImpl searchServiceImpl;
	
	@Mock
	private SearchRepository searchRepository;

	@Test
	public void testFindById() {
		//when(searchRepository.findById(anyString() )). thenReturn(null);
	}

}
