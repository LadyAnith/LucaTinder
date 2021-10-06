package com.example.demo.model;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

@Data
public class Usuario {

	private String id;
	private String nombre;
	private String password;
}
