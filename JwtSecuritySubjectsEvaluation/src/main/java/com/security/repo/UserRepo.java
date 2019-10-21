package com.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.entities.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{
	public Users findByUser(String user);
}
