package com.example.demo.model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Perfil {

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
