package com.fClientStudents.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fClientStudents.clients.WsSubjectsEvaluation;
import com.fClientStudents.model.EvaluationResponse;
import com.fClientStudents.model.SubjectResponse;

@RestController
@RequestMapping("/client")
public class SubjectEvaluationRest {
	@Autowired
	WsSubjectsEvaluation wsSE;
	//Metodos Para La entidad Subjects
	@GetMapping("/subjects")
	public ResponseEntity<Object> findAll(){
		List<SubjectResponse> srList= new ArrayList<SubjectResponse>();
		srList= wsSE.findAll();
		if(srList.size()>0) {
			return new ResponseEntity<>(srList,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("ERROR",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/subjects/findById/{id}")
	public ResponseEntity<Object> findById(@PathVariable Integer id) {
		SubjectResponse sr=wsSE.findSubjectById(id);
		if(null!=sr) {
			return new ResponseEntity<>(sr,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("ERROR",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/subjects/addSubject")
	public ResponseEntity<Object> addSubject(@RequestBody SubjectResponse sr){
		SubjectResponse sres=wsSE.addSubject(sr);
		if(null!= sres) {
			return new ResponseEntity<>(sres,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Error",HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/subjects/updateSubject")
	public ResponseEntity<Object> updateSubject(@RequestBody SubjectResponse sr){
		SubjectResponse sres=wsSE.updateSubject(sr);
		if(null!= sres) {
			return new ResponseEntity<>(sres,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Error",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/evaluation")
	public ResponseEntity<Object> findAllEvaluation(){
		List<EvaluationResponse> evList= new ArrayList<EvaluationResponse>();
		evList= wsSE.findAllEvaluation();
		if(evList.size()>0) {
			return new ResponseEntity<>(evList,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("ERROR",HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/evaluation/selectById/{id}")
	public ResponseEntity<Object> selectEvaluationById(@PathVariable Integer id){
		EvaluationResponse er= wsSE.findEvaluationById(id);
		if(null!=er) {
			return new ResponseEntity<>(er,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Error",HttpStatus.BAD_REQUEST);
		}
	}
}
