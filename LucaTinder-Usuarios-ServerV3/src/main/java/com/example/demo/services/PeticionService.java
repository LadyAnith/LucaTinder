package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.EstadoPeticion;
import com.example.demo.model.Perfil;
import com.example.demo.model.Peticion;

public interface PeticionService {
	public List<Peticion> listadoPeticiones();
	
	public List<Perfil> getPeticionesEmisorPorEstados(String idPerfilEmisor, EstadoPeticion estado);
	
	public List<Perfil> getPeticionesReceptorPendientes(String idPerfilReceptor, EstadoPeticion estado);
	
	public Peticion hacerMatch (String idPerfilEmisor, String idPerfilReceptor);

	public Peticion encontrarPeticionPorId(String id);

	public Peticion guardarPeticion(Peticion peticion);

	public void eliminarPeticionPorId(String id);

	public Optional<Peticion> actualizarPeticion(Peticion peticion);
}
