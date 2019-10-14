package com.fClientStudents.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fClientStudents.clients.WsSubjectsEvaluation;
import com.fClientStudents.model.SubjectResponse;

@RestController
@RequestMapping("/client")
public class SubjectEvaluationRest {
	@Autowired
	WsSubjectsEvaluation wsSE;
	
	@GetMapping
	public List<SubjectResponse> findAll(){
		List<SubjectResponse> srList= new ArrayList<SubjectResponse>();
		srList= wsSE.findAll();
		return srList;
	}
	
	@GetMapping("/findById/{id}")
	public SubjectResponse findById(@PathVariable Integer id) {
		return wsSE.findById(id);
	}
	
	@PostMapping("/addSubject")
	public ResponseEntity<Object> addSubject(@RequestBody SubjectResponse sr){
		SubjectResponse sres=wsSE.addSubject(sr);
		if(null!= sres) {
			return new ResponseEntity<>("Success",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Error",HttpStatus.BAD_REQUEST);
		}
	}
}
