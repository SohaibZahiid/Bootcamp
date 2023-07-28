package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ej2Controller {

	@RequestMapping("/ej2")
	public String index() {
		return "Home Page";
	}
	
	@RequestMapping("/ej2/about")
	public String about() {
		return "About";
	}
	
	@RequestMapping("/ej2/contact")
	public String contact() {
		return "Contact";
	}
}
