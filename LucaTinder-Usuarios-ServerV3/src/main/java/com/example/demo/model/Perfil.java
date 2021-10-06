package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Document(collection = "Perfil")
@Data
public class Perfil implements Serializable {

	private static final long serialVersionUID = -4299885995482111879L;

	@Id
	@ApiModelProperty(required = false, hidden = true)
	private String id;
	private String nombre;
	private String apellidos;
	private int edad;
	private String sexo;
	private String ciudad;
	private String foto;
	private List<Materia> materia;

}
