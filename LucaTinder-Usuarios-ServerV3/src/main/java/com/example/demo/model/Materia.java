package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Document(collection = "Materias")
public class Materia {
	@Id
	@ApiModelProperty(required = false, hidden = true)
	private String id;
	private String name;
}
