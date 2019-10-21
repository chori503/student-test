package com.fClientStudents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fClientStudents.clients.WsSubjectsEvaluation;
import com.fClientStudents.model.EvaluationResponse;
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

	public SubjectResponse selectSubjectById(Integer id) {
		try {
			SubjectResponse sr = seCli.findSubjectById(id);
			return sr;
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

	// Creando Los Metodos para Utilizar el ws De Evaluation
	public List<EvaluationResponse> showEvaluation() {
		try {
			List<EvaluationResponse> seList = seCli.findAllEvaluation();
			return seList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public EvaluationResponse selectEvaluationById(Integer id) {
		try {
			EvaluationResponse er = seCli.findEvaluationById(id);
			return er;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public EvaluationResponse addEvaluation(EvaluationResponse er) {
		try {
			EvaluationResponse eRes = seCli.addEvaluation(er);
			return eRes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public EvaluationResponse updateEvaluation(EvaluationResponse er) {
		try {
			EvaluationResponse eRes = seCli.updateEvaluation(er);
			return eRes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
