package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@RequestMapping(value = {"/hello", "hola", "salut"})
	public String index() {
		return "Hello, hola, salut";
	}
}
