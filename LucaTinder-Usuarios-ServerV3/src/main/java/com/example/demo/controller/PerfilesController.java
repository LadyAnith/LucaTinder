package com.example.demo.controller;

import java.net.URI;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.Perfil;
import com.example.demo.services.PerfilServices;

@RestController
@RequestMapping("/perfiles")
public class PerfilesController {
	
	@Autowired
	private PerfilServices service;


	@GetMapping(value = "/all")
	public Collection<Perfil> leerPerfil() {
		return service.listarPerfil();
	}
	
	
	@GetMapping(value = "/{id}")
	public Perfil encontrarPorId(@PathVariable String id) {
		System.out.println("-------- readEvent");
		return service.encontrarPerfilPorId(id);
	}
	

	
	@PostMapping(value = "/add")
	public ResponseEntity<?> addPerfil(@RequestBody Perfil perfil) {
		Perfil result = this.service.guardar(perfil);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	 //Actualizar un Perfil
		@PutMapping("/{id}")
		public Perfil updatePerfil(@PathVariable String id, @Valid @RequestBody Perfil perfil) {

			Perfil result = this.service.actualizarPerfil(perfil).orElseThrow(null);
			System.out.println("ooooooooooooooooooooooooo"+ result);
			return result;
		}

	@DeleteMapping(value = "/{id}")
	public void eliminarPerfil(@PathVariable String id) {
		service.eliminarPerfilPorId(id);
	}
}
