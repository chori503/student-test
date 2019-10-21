package com.security.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexRest {
	@GetMapping
	public String index() {
		return "HELLO INDEX";
	}
}
