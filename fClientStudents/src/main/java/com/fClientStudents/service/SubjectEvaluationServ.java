package com.fClientStudents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fClientStudents.clients.WsSubjectsEvaluation;
import com.fClientStudents.model.SubjectResponse;

@Service
public class SubjectEvaluationServ {
	@Autowired
	WsSubjectsEvaluation seCli;
	
	public SubjectResponse addSubject(SubjectResponse sr) {
		try {
			SubjectResponse sRes = seCli.addSubject(sr);
			return sRes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
