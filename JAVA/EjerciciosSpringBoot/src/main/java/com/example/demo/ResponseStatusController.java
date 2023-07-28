package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseStatusController {

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping("/apiVersion/hacercafe")
	public String index() {
		return "Cafe";
	}
	
	@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
	@RequestMapping("/apiVersion/hacerte")
	public String hacerte() {
		return "Hacerte Cafe";
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@RequestMapping("/apiVersion/notfound")
	public String notfound() {
		return "NotFound";
	}
}
