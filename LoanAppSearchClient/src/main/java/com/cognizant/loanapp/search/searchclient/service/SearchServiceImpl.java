package com.cognizant.loanapp.search.searchclient.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.loanapp.search.searchclient.entity.Loan;
import com.cognizant.loanapp.search.searchclient.exception.LoanNotFoundException;
import com.cognizant.loanapp.search.searchclient.repository.SearchRepository;

@Service
public class SearchServiceImpl implements SearchService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SearchRepository searchrepository;


	@Override
	public Iterable<Loan> findAll() {
		
		return searchrepository.findAll();
	}
	
	@Override
	public Optional<Loan> findById(int loanId) {
		
		logger.info("Before find By Id method call");
		
		return searchrepository.findById(loanId);
	}

	@Override
	public Optional<List<Loan>> findByAmount(double amount) {
		
		long count = searchrepository.countByAmount(amount);
		
		logger.info("Length of the repo list" +count );
		
		return searchrepository.findByAmount(amount);
	}

	
	 @Override 
	 public Optional<List<Loan>> findByBorrowerName(String borrowerName) {
		 
		 logger.info("Before find By borrower name method call" );
		 
	     return searchrepository.findByBorrowerName(borrowerName); 
	    }

	@Override
	public Loan save(Loan loanInfo) {
		return searchrepository.save(loanInfo);
	}

	@Override
	public Optional<List<Loan>> findByBorrowerNameAndAmount(String borrowerName, double amount) {
		
		logger.info("Before find By borrower name and amount method call" );
		 
	    return searchrepository.findByBorrowerNameAndAmount(borrowerName, amount); 
	}

	@Override
	public Optional<List<Loan>> findByNumberAndAmount(int id, double amount) {
		
		return searchrepository.findByNumberAndAmount(id, amount);
	}

	@Override
	public Optional<List<Loan>> findByNumberAndName(int id, String borrowerName) {
		
		return searchrepository.findByNumberAndName(id, borrowerName);
	}
	

}
	
	


