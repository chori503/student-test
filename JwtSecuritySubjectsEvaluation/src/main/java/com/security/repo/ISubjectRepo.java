package com.security.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.entities.Subject;

@Repository
public interface ISubjectRepo extends JpaRepository<Subject, Integer>{
	List<Subject> findByName(String name);
}
