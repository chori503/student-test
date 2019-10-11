package com.wsSubjectEvaluations.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wsSubjectEvaluations.entities.Subject;

@Repository
public interface ISubjectRepo extends JpaRepository<Subject, Integer>{

}
