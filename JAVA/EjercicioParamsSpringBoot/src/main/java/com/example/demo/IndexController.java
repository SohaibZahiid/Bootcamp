package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
public class IndexController {

	@RequestMapping("/welcome")
	public ObjectNode index(@RequestParam String name, String surname) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		node.put("name", name);
		node.put("surname", surname);
		return node;
	}
	
	@RequestMapping("/welcomestranger")
	public ObjectNode stranger(@RequestParam (required = false, defaultValue = "Stranger") String name, @RequestParam (required = false, defaultValue = "Stranger") String surname) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		node.put("name", name);
		node.put("surname", surname);
		return node;
	}
}
