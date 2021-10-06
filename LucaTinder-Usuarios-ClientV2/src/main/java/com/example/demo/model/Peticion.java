package com.example.demo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Peticion {


	@ApiModelProperty(required = false, hidden = true)
	private String id;
	private String idPerfilEmisor;
	private String idPerfilReceptor;
	private EstadoPeticion estado;
}
