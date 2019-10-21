package com.fClientStudents.clients;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fClientStudents.model.EvaluationResponse;
import com.fClientStudents.model.SubjectResponse;

@FeignClient(name = "SubjectEvaluation" ,url = "${feign.subjectEvaluationWs.url}")
public interface WsSubjectsEvaluation {
	@GetMapping("/subjects/show")
	public List<SubjectResponse> findAll();
	
	@GetMapping("/subjects/findById/{id}")
	public SubjectResponse findSubjectById(@PathVariable Integer id);
	
	@PostMapping("/subjects/addSubject")
	public SubjectResponse addSubject(@RequestBody SubjectResponse sr);
	
	@PutMapping("/subjects/updateSubject")
	public SubjectResponse updateSubject(@RequestBody SubjectResponse sr);
	
	//////////////////////////////////seccion de evaluaciones
	
	@GetMapping("/evaluation/show")
	public List<EvaluationResponse> findAllEvaluation();
	
	@GetMapping("/evaluation/findById/{id}")
	public EvaluationResponse findEvaluationById(@PathVariable Integer id);
	
	@PostMapping("/evaluation/addEvaluation")
	public EvaluationResponse addEvaluation(@RequestBody EvaluationResponse er);
	
	@PutMapping("/evaluation/updateEvaluation")
	public EvaluationResponse updateEvaluation(@RequestBody EvaluationResponse er);
}
