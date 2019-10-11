package com.wsSubjectEvaluations.rest;

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

import com.wsSubjectEvaluations.entities.Evaluation;
import com.wsSubjectEvaluations.entities.Subject;
import com.wsSubjectEvaluations.service.EvaluationServ;

@RestController
@RequestMapping("/evaluation")
public class EvaluationRest {
	@Autowired
	EvaluationServ eServ;
	List<Evaluation> eList = new ArrayList<Evaluation>();
	
	@GetMapping
	public ResponseEntity<Object> findAll(){
		try {
			eList = eServ.findAll();
			if(eList.size()>0) {
				return new ResponseEntity<>(eList,HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST.getReasonPhrase(),HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	@GetMapping("findById/{id}")
	public ResponseEntity<Object> findById(@PathVariable("id") int id){
		Evaluation ev= new Evaluation();
	try {
		ev= eServ.SelectById(id);
		return new ResponseEntity<>(ev,HttpStatus.OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<>("None",HttpStatus.BAD_REQUEST);
	}
	}
	@PostMapping("/addEvaluation")
	public ResponseEntity<Object> addSubject(@RequestBody Evaluation eva) {
		Evaluation ev = eServ.addEvaluation(eva);
		if(eva!=null) {
			System.out.println("IDDDDDDDDDD  "+eva.getId());
			return new ResponseEntity<>("Added successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/updateEvaluation")
	public ResponseEntity<Object> updateSubject(@RequestBody Evaluation eva) {
		Evaluation ev = eServ.updateEvaluation(eva);
		if(eva!=null) {
			return new ResponseEntity<>("Updated successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
		}
	}
}
