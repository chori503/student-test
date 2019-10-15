package com.fClientStudents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fClientStudents.clients.WsSubjectsEvaluation;
import com.fClientStudents.model.SubjectResponse;

@Service
public class SubjectEvaluationServ {
	@Autowired
	WsSubjectsEvaluation seCli;

//Creando Los Metodos para Utilizar el ws De Subjects
	public List<SubjectResponse> showSubjects() {
		try {
			List<SubjectResponse> srList = seCli.findAll();
			return srList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public SubjectResponse addSubject(SubjectResponse sr) {
		try {
			SubjectResponse sRes = seCli.addSubject(sr);
			return sRes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public SubjectResponse updateSubject(SubjectResponse sr) {
		try {
			SubjectResponse sRes = seCli.updateSubject(sr);
			return sRes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
