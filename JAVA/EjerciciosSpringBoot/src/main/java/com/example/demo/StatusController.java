package com.example.demo;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

	@RequestMapping("/status")
	public ResponseEntity<String> index() {
		Random r = new Random();
		int random = r.nextInt(2);
		return new ResponseEntity<String>("response", random == 0 ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}
}
