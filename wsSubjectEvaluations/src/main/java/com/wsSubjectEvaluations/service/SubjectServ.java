package com.wsSubjectEvaluations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsSubjectEvaluations.entities.Subject;
import com.wsSubjectEvaluations.repo.ISubjectRepo;

@Service
public class SubjectServ {
	@Autowired
	ISubjectRepo sRepo;

	public Subject addSubject(Subject s) {
		try {
			Subject sub = sRepo.save(s);
			return sub;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Subject updateSubject(Subject s) {
		try {
			Subject sub = sRepo.save(s);
			return sub;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Subject> findAll() {
		try {
			return sRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Subject selectById(Integer id) {
		try {
			Subject sub = sRepo.findById(id).get();
			return sub;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
