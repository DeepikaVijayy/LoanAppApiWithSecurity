package com.cognizant.loanapp.search.searchclient.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.loanapp.search.searchclient.entity.LoanErrorResponse;
import com.cognizant.loanapp.search.searchclient.entity.Loan;
import com.cognizant.loanapp.search.searchclient.exception.LoanNotFoundException;
import com.cognizant.loanapp.search.searchclient.service.SearchServiceImpl;

@RestController
@RequestMapping("/loanapp")
@CrossOrigin(origins= "http://localhost:4200")
public class SearchController {
	
	// default constructor
	public SearchController() {
	}
	
	@Autowired
	private SearchServiceImpl searchService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	List<Loan> loanList = new ArrayList<Loan>();
	
	Iterable<Loan> loanIterator;
	
	// Search all Loan by loan number
    @GetMapping("/loans")
	public List<Loan> findAll() {
    	
    	loanIterator = searchService.findAll();
    	
    	loanIterator.forEach(loanList::add);
			
		return loanList;
			
	}
		
	// Search Loan by loan number
	@GetMapping("/loans/{id}")
	public Loan findById(@PathVariable("id") int loanId) {
		
		Optional<Loan> loanInfo = searchService.findById(loanId);
		
		loanInfo.orElseThrow(() -> new LoanNotFoundException("Loan not found with the loan id " +loanId));
		 
		return loanInfo.get();
		
	}
	
	// Search Loan by loan amount
	@GetMapping("/loanByAmount/{amount}")
	public List<Loan> findByAmount(@PathVariable("amount") double amount) {
		
        List<Loan> loanList = new ArrayList<Loan>();
		
		Optional<List<Loan>> loanInfo = searchService.findByAmount(amount);
		
		loanInfo.orElseThrow(() -> new LoanNotFoundException("Loan not found wiht the loan amount " +amount));
		
		for(Loan loan : loanInfo.get()) {
			
			loanList= Arrays.asList(loan);	
		}		
		return loanList;		
	}
	 
	// Search Loan by borrower name
	@GetMapping("/loanByBorrowerName/{borrowerName}")
	public List<Loan> findByBorrowerName(@PathVariable("borrowerName") String borrowerName) {
			
        List<Loan> loanList = null;
		
		Optional<List<Loan>> loanInfo = searchService.findByBorrowerName(borrowerName);
		
		loanInfo.orElseThrow(() -> new LoanNotFoundException("Loan not found with the borrower name " +borrowerName));
		
		for(Loan loan : loanInfo.get()) {
			
			loanList= Arrays.asList(loan);	
		}		
		return loanList;
			
	   }
	
   // Search Loan by borrower name and amount
   @GetMapping("/loanByNameAndAmount/{borrowerName}/{amount}")
   public List<Loan> findByBorrowerNameAndAmount(@PathVariable("borrowerName") String borrowerName
		  , @PathVariable("amount") double amount) {
		
       List<Loan> loanList = null;
	
	   Optional<List<Loan>> loanInfo = searchService.findByBorrowerNameAndAmount(borrowerName, amount);
	
	   loanInfo.orElseThrow(() -> new LoanNotFoundException("Loan not found with the borrower name and amount" 
	                 +borrowerName+ "," +amount));
	
	   for(Loan loan : loanInfo.get()) {
		
		   loanList= Arrays.asList(loan);	
	   }		
	   return loanList;
		
     }
   
   // Search Loan by borrower name and amount
   @GetMapping("/loanByNumberAndAmount/{id}/{amount}")
   public List<Loan> findByNumberAndAmount(@PathVariable("id") int id
		  , @PathVariable("amount") double amount) {
		
       List<Loan> loanList = null;
	
	   Optional<List<Loan>> loanInfo = searchService.findByNumberAndAmount(id, amount);
	
	   loanInfo.orElseThrow(() -> new LoanNotFoundException("Loan not found with the borrower name and amount" 
	                 +id+ "," +amount));
	
	   for(Loan loan : loanInfo.get()) {
		
		   loanList= Arrays.asList(loan);	
	   }		
	   return loanList;
		
     }
   
   // Search Loan by borrower name and amount
   @GetMapping("/loanByNumberAndName/{id}/{borrowerName}")
   public List<Loan> findByNumberAndName(@PathVariable("id") int id
		  , @PathVariable("borrowerName") String borrowerName) {
		
       List<Loan> loanList = null;
	
	   Optional<List<Loan>> loanInfo = searchService.findByNumberAndName(id, borrowerName);
	
	   loanInfo.orElseThrow(() -> new LoanNotFoundException("Loan not found with the loan number and borrower name" 
	                 +id+ "," +borrowerName));
	
	   for(Loan loan : loanInfo.get()) {
		
		   loanList= Arrays.asList(loan);	
	   }		
	   return loanList;
		
     }
   
	
	// create/update a loan resource
	@PostMapping("/loans")
	public Loan createLoan(@RequestBody Loan loanInfo) {
		
		return searchService.save(loanInfo);
	}


}
