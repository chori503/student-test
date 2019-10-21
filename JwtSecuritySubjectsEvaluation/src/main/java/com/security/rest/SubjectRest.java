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

import com.security.entities.ResponseObject;
import com.security.entities.Subject;
import com.security.service.SubjectServ;

@RestController
@RequestMapping("/subjects")
public class SubjectRest {

	@Autowired
	SubjectServ sServ;

	// Haciendo una lista de tipo subject para mostrar todos los registros
	@GetMapping
	public ResponseEntity<Object> findAll() {
		List<Subject> subjectList = new ArrayList<Subject>();
		subjectList = sServ.findAll();
		// validando si hay registros muestra un OK sino muestra un bad request
		if (subjectList.size() > 0) {
			ResponseObject rObject = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.OK, "Success",
					"subjects", subjectList);

			return new ResponseEntity<>(rObject, HttpStatus.OK);

		} else {
			ResponseObject rObject = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.BAD_REQUEST,
					"Faillure", "subjects", subjectList);

			return new ResponseEntity<>(rObject, HttpStatus.BAD_REQUEST);

		}
	}
	@GetMapping("/show")
	public ResponseEntity<Object> showAll() {
		List<Subject> subjectList = new ArrayList<Subject>();
		subjectList = sServ.findAll();
		// validando si hay registros muestra un OK sino muestra un bad request
		if (subjectList.size() > 0) {
			ResponseObject rObject = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.OK, "Success",
					"subjects", subjectList);

			return new ResponseEntity<>(subjectList, HttpStatus.OK);

		} else {
			ResponseObject rObject = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.BAD_REQUEST,
					"Faillure", "subjects", subjectList);

			return new ResponseEntity<>(subjectList, HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Object> findById(@PathVariable("id") int id) {
		System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
		Subject s = new Subject();
		try {
			s = sServ.selectById(id);
			if (null != s) {
				ResponseObject rObject = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.OK,
						"Success", "/findById/{id}", s);

				return new ResponseEntity<>(rObject, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			ResponseObject rObject = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.BAD_REQUEST,
					"Faillure", "/findById/{id}", s);

			return new ResponseEntity<>(rObject, HttpStatus.BAD_REQUEST);

		}
		return null;
	}

	@PostMapping("/addSubject")
	public ResponseEntity<Object> addSubject(@RequestBody Subject sub) {
		Subject s = sServ.addSubject(sub);
		if (null != s) {
			ResponseObject rObject = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.OK, "Success",
					"/addSubject", s);

			return new ResponseEntity<>(rObject, HttpStatus.OK);
		} else {
			ResponseObject rObject = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.BAD_REQUEST,
					"Faillure", "/addSubject", s);

			return new ResponseEntity<>(rObject, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateSubject")
	public ResponseEntity<Object> updateSubject(@RequestBody Subject sub) {
		Subject s = sServ.updateSubject(sub);
		if (null != s) {
			ResponseObject rObject = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.OK, "Success",
					"/updateSubject", s);

			return new ResponseEntity<>(rObject, HttpStatus.OK);
		} else {
			ResponseObject rObject = new ResponseObject(new Timestamp(new Date().getTime()), HttpStatus.BAD_REQUEST,
					"Faillure", "/updateSubject", s);

			return new ResponseEntity<>(rObject, HttpStatus.BAD_REQUEST);
		}
	}

}
