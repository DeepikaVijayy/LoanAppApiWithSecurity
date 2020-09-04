package com.cognizant.loanapp.search.searchclient.service;

import java.util.List;
import java.util.Optional;

import com.cognizant.loanapp.search.searchclient.entity.Loan;

public interface SearchService {
	// get all the loans
	public Iterable<Loan> findAll();
	
	// Search by Loan number
	public Optional<Loan> findById(int loanId);
	
	// Search by Loan Amount
	public Optional<List<Loan>> findByAmount(double amount);
	
	// Search by Borrower name
	public Optional<List<Loan>> findByBorrowerName(String borrowerName);
	
	// Search by Borrower name and loan amount
	public Optional<List<Loan>> findByBorrowerNameAndAmount(String borrowerName, double amount);
	
	// Search by loan number and loan amount
    public Optional<List<Loan>> findByNumberAndAmount(int id, double amount);
    
    // Search by loan number and borrower name
    public Optional<List<Loan>> findByNumberAndName(int id, String borrowerName);
	
	// Save the Loan Information
	public Loan save(Loan loanInfo);


}
