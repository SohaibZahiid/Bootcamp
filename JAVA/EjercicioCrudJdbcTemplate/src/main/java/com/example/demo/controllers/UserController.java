package com.example.demo.controllers;

import com.example.demo.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private JdbcTemplate jdbcTemplate;
	
	public UserController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		final String q = "DELETE FROM usuarios WHERE id_usuarios = ?";
		int deleted = jdbcTemplate.update(q, id);
		if(deleted == 1) {
			return ResponseEntity.ok("User deleted successfully");
		} else {
			return ResponseEntity.status(HttpStatusCode.valueOf(400)).body("Something went wrong");
		}
	}

	@PostMapping("update/{id}")
	public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody User user) {
		final String q = "UPDATE usuarios SET nombre = ?, edad = ?, nacionalidad = ? WHERE id_usuarios = ?";
		System.out.println(q);
		int updated = jdbcTemplate.update(q, user.getName(), user.getAge(), user.getNationality(), id);
		if(updated == 1) {
			return ResponseEntity.ok("User updated successfully");
		} else {
			return ResponseEntity.status(HttpStatusCode.valueOf(400)).body("Something went wrong");
		}

	}

	@PutMapping("add")
	public String addUser(@RequestBody User user) {
		final String q = "INSERT INTO usuarios (nombre, edad, nacionalidad) VALUES(?, ?, ?)";
		int inserted = jdbcTemplate.update(q, user.getName(), user.getAge(), user.getNationality());
		return inserted == 1 ? "User created successfully" : "Something went wrong";
	}

	@RequestMapping(value = "{id}", method = {RequestMethod.GET, RequestMethod.POST} )
	public List<String> getUser(@PathVariable int id) {
		final String q = "SELECT * FROM usuarios WHERE id_usuarios = " + id;
		
		List<Map<String, Object>> result = jdbcTemplate.queryForList(q);
		
		List<String> user = new ArrayList<String>();
		
		for (Map<String, Object> u : result) {
			user.add(u.toString());
		}
		
		return user;
		
		//return " id " + id;
	}
	
	@GetMapping()
	public List<String> getUsers() {
		final String q = "SELECT * FROM usuarios";
		
		List<Map<String, Object>> results = jdbcTemplate.queryForList(q);
		
		List<String> userList = new ArrayList<String>();
		
		for (Map<String, Object> user : results) {
			userList.add(user.toString());
		}
		
		return userList;
	}

}
