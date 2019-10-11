package com.wsSubjectEvaluations.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wsSubjectEvaluations.entities.Evaluation;

@Repository
public interface EvaluationRepo extends JpaRepository<Evaluation, Integer>{

	
}
