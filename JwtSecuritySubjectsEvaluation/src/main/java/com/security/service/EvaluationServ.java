package com.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.entities.Evaluation;
import com.security.repo.EvaluationRepo;

@Service
public class EvaluationServ {
	@Autowired
	EvaluationRepo eRepo;
	
	List<Evaluation> eList = new ArrayList<Evaluation>();
	
	public List<Evaluation> findAll(){
		try {
			eList= eRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eList;
	}

	public Evaluation addEvaluation(Evaluation ev) {
		try {
			Evaluation e = eRepo.save(ev);
			return e;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Evaluation updateEvaluation(Evaluation ev) {
		try {
			Evaluation evaluation= eRepo.save(ev);
			return evaluation;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Evaluation SelectById(Integer id) {
		try {
			Evaluation evaluation= eRepo.findById(id).get();
			return evaluation;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
