package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Usuarios")
public class Usuario {
	@Id
	private String id;
	private String nombre;
	private String password;
}
