package com.cognizant.loanapp.search.searchclient.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cognizant.loanapp.search.searchclient.entity.Loan;

@Repository

public interface SearchRepository extends CrudRepository<Loan, Integer> {

	public Optional<Loan> findById(int id);
	
	@Query("select L from Loan L where L.loanAmount = :amount")
	public Optional<List<Loan>> findByAmount(double amount);
	
	@Query("select count(L) from Loan L where L.loanAmount = :amount")
	public Long countByAmount(double amount);
	
	@Query("select L from Loan L inner join BorrowerInformation B "
			+ " on L.borrower = B.id where B.borrowerName = :borrowerName")
	public Optional<List<Loan>> findByBorrowerName(String borrowerName);

	@Query("select L from Loan L inner join BorrowerInformation B "
			+ " on L.borrower = B.id where B.borrowerName = :borrowerName and L.loanAmount = :amount")
	public Optional<List<Loan>> findByBorrowerNameAndAmount(String borrowerName, double amount); 
	
	@Query("select L from Loan L inner join BorrowerInformation B "
			+ " on L.borrower = B.id where L.loanId = :id and L.loanAmount = :amount")
	public Optional<List<Loan>> findByNumberAndAmount(int id, double amount); 
	
	
	@Query("select L from Loan L inner join BorrowerInformation B "
			+ " on L.borrower = B.id where B.borrowerName = :borrowerName and L.loanId = :id")
	public Optional<List<Loan>> findByNumberAndName(int id, String borrowerName); 
	
	
	/* public Loan save(Loan loanInfo); */
}
