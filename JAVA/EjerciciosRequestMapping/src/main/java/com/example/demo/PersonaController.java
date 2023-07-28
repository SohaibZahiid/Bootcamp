package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class PersonaController {

	@GetMapping
	public String persona() {
		Persona persona = new Persona("Sohaib", "Zahid", 23);
		return persona.toString();
	}
	
	@PostMapping
	public String crearPersona(@RequestParam String name,@RequestParam String surname,@RequestParam int age) {
		Persona persona = new Persona(name, surname, age);
		return persona.toString();
	}
	
	@DeleteMapping
	public String deletePerona(@RequestParam int id) {
		return "Person with id " + id + " deleted";
	}
	
	@PutMapping
	public String putPersona(@RequestBody Object obj) {
		return obj + " Introducido correctamente";
	}
}
