package com.cognizant.loanapp.apigateway.loanapi.reposiory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.loanapp.apigateway.loanapi.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByUserName(String userName);
}
