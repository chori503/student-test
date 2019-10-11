package com.wsSubjectEvaluations.rest;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

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

import com.wsSubjectEvaluations.entities.Subject;
import com.wsSubjectEvaluations.models.SubjectModel;
import com.wsSubjectEvaluations.service.SubjectServ;

@RestController
@RequestMapping("/subjects")
public class SubjectRest {
	
	@Autowired
	SubjectServ sServ;
	
	@GetMapping
	public ResponseEntity<Object> findAll(){
		List<Subject> subjectList = new ArrayList<Subject>();
		subjectList = sServ.findAll();
		SubjectModel sm = new SubjectModel();
		List<SubjectModel> smList = new ArrayList<SubjectModel>();
		
		for(Subject s : subjectList) {
		sm.setId(s.getId());
		sm.setName(s.getName());
		sm.setState(s.getState());
		sm.setDateCreation(s.getDateCreation());
		sm.setDateMerge(s.getDateMerge());
		sm.setDateRemoved(s.getDateRemoved());
		smList.add(sm);
		}
		return new ResponseEntity<>(subjectList,HttpStatus.OK);
	}
	@GetMapping("findById/{id}")
	public ResponseEntity<Object> findById(@PathVariable("id") int id){
	System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
		Subject s = new Subject();
	try {
		s= sServ.selectById(id);
		return new ResponseEntity<>(s,HttpStatus.OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<>("None",HttpStatus.BAD_REQUEST);
	}
	}
	@PostMapping("/addSubject")
	public ResponseEntity<Object> addSubject(@RequestBody Subject sub) {
		Subject s =sServ.addSubject(sub);
		if(s!=null) {
			System.out.println("IDDDDDDDDDD  "+s.getId());
			return new ResponseEntity<>("Added successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/updateSubject")
	public ResponseEntity<Object> updateSubject(@RequestBody Subject sub) {
		Subject s =sServ.updateSubject(sub);
		if(s!=null) {
			return new ResponseEntity<>("Updated successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
		}
	}

}
