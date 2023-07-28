package com.example.demo;

public class Persona {
	private String name;
	private String surname;
	private int age;
	
	public Persona() {
		super();
	}
	
	public Persona(String name, String surname, int age) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Persona [name=" + name + ", surname=" + surname + ", age=" + age + "]";
	}
	

	
}
