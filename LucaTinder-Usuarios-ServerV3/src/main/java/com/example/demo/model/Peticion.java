package com.example.demo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Document(collection = "Peticion")
@Data
public class Peticion {

	@Id
	@ApiModelProperty(required = false, hidden = true)
	private String id;
	private String idPerfilEmisor;
	private String idPerfilReceptor;
	private EstadoPeticion estado;
}

