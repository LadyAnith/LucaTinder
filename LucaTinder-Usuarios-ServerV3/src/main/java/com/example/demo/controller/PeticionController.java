package com.example.demo.controller;

import java.net.URI;
import java.util.Collection;
import java.util.List;

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

import com.example.demo.model.EstadoPeticion;
import com.example.demo.model.Perfil;
import com.example.demo.model.Peticion;
import com.example.demo.services.PeticionService;

@RestController
@RequestMapping("/peticiones")
public class PeticionController {
	@Autowired
	private PeticionService service;


	@GetMapping(value = "/all")
	public Collection<Peticion> listadoPeticiones() {
		return service.listadoPeticiones();
	}
	
	@GetMapping(value = "/getPeticionesEmisorPorEstados")
	public List<Perfil> listadoContactos(String idPerfilEmisor, EstadoPeticion estado) {
		return service.getPeticionesEmisorPorEstados(idPerfilEmisor, estado);
	}
	
	@GetMapping(value = "/getPeticionesReceptorPorEstados")
	public List<Perfil> listadoPeticionesMatchPendientes(String idPerfilReceptor, EstadoPeticion estado) {
		return service.getPeticionesReceptorPendientes(idPerfilReceptor, estado);
	}
	
	@GetMapping(value = "/match")
	public Peticion match(String idPerfilEmisor, String idPerfilReceptor) {
		return service.hacerMatch(idPerfilEmisor, idPerfilReceptor);
	}
	
	
	
	@GetMapping(value = "/{id}")
	public Peticion encontrarPorId(@PathVariable String id) {
		System.out.println("-------- readEvent");
		return service.encontrarPeticionPorId(id);
	}
	

	
	@PostMapping(value = "/add")
	public ResponseEntity<?> addPeticion(@RequestBody Peticion peticion) {
		Peticion result = this.service.guardarPeticion(peticion);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
		@PutMapping("/{id}")
		public Peticion updatePeticion(@PathVariable String id, @Valid @RequestBody Peticion peticion) {

			Peticion result = this.service.actualizarPeticion(peticion).orElseThrow(null);
			return result;
		}

	@DeleteMapping(value = "/{id}")
	public void eliminarPeticion(@PathVariable String id) {
		service.eliminarPeticionPorId(id);
	}
}
