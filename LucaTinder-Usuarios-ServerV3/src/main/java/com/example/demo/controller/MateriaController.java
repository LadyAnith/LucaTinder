package com.example.demo.controller;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.Materia;
import com.example.demo.services.MateriaService;

@RestController
@RequestMapping("/materias")
public class MateriaController {
	@Autowired
	MateriaService service;
	
	@GetMapping(value = "/all")
	public Collection<Materia> leerMateria() {
		return service.listarMateria();
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> addMateria(@RequestBody Materia materia) {
		Materia result = this.service.guardar(materia);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminarMateria(@PathVariable String id) {
		service.eliminarMateriaPorId(id);
	}
	
}
