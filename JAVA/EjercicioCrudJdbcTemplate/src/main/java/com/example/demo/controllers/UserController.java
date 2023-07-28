package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private JdbcTemplate jdbcTemplate;
	
	public UserController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
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
