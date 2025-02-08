package com.example.tiptop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tiptop.beans.User;


public interface UserRepository extends JpaRepository<User, Integer> {

//	User findByusername(String username);
	 
	User findByemail(String email);



}
