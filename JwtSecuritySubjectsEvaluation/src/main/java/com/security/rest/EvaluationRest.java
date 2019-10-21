package com.security.rest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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

import com.security.entities.Evaluation;
import com.security.entities.ResponseObject;
import com.security.service.EvaluationServ;

@RestController
@RequestMapping("/evaluation")
public class EvaluationRest {

//	Injection to the repository Class
	@Autowired
	EvaluationServ eServ;
	List<Evaluation> eList = new ArrayList<Evaluation>();

	@GetMapping
	public ResponseEntity<Object> findAll() {
		try {
			eList = eServ.findAll();
			// Checking if the Evaluation List is not null to send a response
			if (eList.size() > 0) {
				ResponseObject rObject = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.OK,
						"Success", "/evaluation", eList);

				return new ResponseEntity<>(rObject, HttpStatus.OK);
			}
		} catch (Exception e) {
			ResponseObject rObject = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.BAD_REQUEST,
					"Faillure", "/evaluation", eList);

			return new ResponseEntity<>(rObject, HttpStatus.BAD_REQUEST);
		}
		return null;
	}

	@GetMapping("/show")
	public ResponseEntity<Object> showAll() {
		try {
			eList = eServ.findAll();
			// Checking if the Evaluation List is not null to send a response
			if (eList.size() > 0) {
				ResponseObject rObject = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.OK,
						"Success", "/evaluation", eList);

				return new ResponseEntity<>(eList, HttpStatus.OK);
			}
		} catch (Exception e) {
			ResponseObject rObject = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.BAD_REQUEST,
					"Faillure", "/evaluation", eList);

			return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
		}
		return null;
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Object> findById(@PathVariable("id") int id) {
		Evaluation ev = new Evaluation();
		try {
			ev = eServ.SelectById(id);
			if (null != ev) {
				ResponseObject rObject = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.OK,
						"Success", "/findById/{id}", ev);

				return new ResponseEntity<>(rObject, HttpStatus.OK);
			}
		} catch (Exception e) {
			ResponseObject rObject = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.BAD_REQUEST,
					"Faillure", "/findById/{id}", ev);

			return new ResponseEntity<>(rObject, HttpStatus.BAD_REQUEST);
		}
		return null;
	}

	@PostMapping("/addEvaluation")
	public ResponseEntity<Object> addSubject(@RequestBody Evaluation eva) {
		Evaluation ev = eServ.addEvaluation(eva);
		if (ev != null) {
			ResponseObject rObject = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.OK, "Success",
					"/addEvaluation", ev);

			return new ResponseEntity<>(rObject, HttpStatus.OK);
		} else {
			ResponseObject rObject = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.BAD_REQUEST,
					"Faillure", "/addEvaluation", ev);

			return new ResponseEntity<>(rObject, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateEvaluation")
	public ResponseEntity<Object> updateSubject(@RequestBody Evaluation eva) {
		Evaluation ev = eServ.updateEvaluation(eva);
		if (ev != null) {
			ResponseObject rObject = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.OK, "Success",
					"/addEvaluation", ev);

			return new ResponseEntity<>(rObject, HttpStatus.OK);
		} else {
			ResponseObject rObject = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.BAD_REQUEST,
					"Faillure", "/addEvaluation", ev);

			return new ResponseEntity<>(rObject, HttpStatus.BAD_REQUEST);
		}
	}
}
