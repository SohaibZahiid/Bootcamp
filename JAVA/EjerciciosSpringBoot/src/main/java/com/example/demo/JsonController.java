package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
public class JsonController {
	
	@RequestMapping("/json")
	public TextToJson index() {
		return new TextToJson("Home Page");
	}
	
	@RequestMapping(path = "/json2", produces = "application/json")
	public String json() {
		return "{\"page\": \"Json formatted\"}";
	}
	
	@RequestMapping("/json3")
	public ObjectNode json3() {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		node.put("key", "value");
		return node;
	}
}
