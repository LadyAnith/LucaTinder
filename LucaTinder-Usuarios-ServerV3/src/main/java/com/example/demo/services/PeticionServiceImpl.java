package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EstadoPeticion;
import com.example.demo.model.Perfil;
import com.example.demo.model.Peticion;
import com.example.demo.repository.PeticionRepository;

@Service
public class PeticionServiceImpl implements PeticionService {

	@Autowired
	PeticionRepository repo;

	@Autowired
	PerfilServices serviPerfil;

	@Override
	public List<Peticion> listadoPeticiones() {
		return repo.findAll();
	}

	@Override
	public Peticion encontrarPeticionPorId(String id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Peticion guardarPeticion(Peticion peticion) {
		return repo.save(peticion);
	}

	@Override
	public void eliminarPeticionPorId(String id) {
		repo.deleteById(id);

	}

	@Override
	public Optional<Peticion> actualizarPeticion(Peticion peticion) {
		Peticion peticionVieja = repo.findById(peticion.getId()).orElse(null);

		Optional<Peticion> result = Optional.ofNullable(peticionVieja);

		return result;
	}

	@Override
	public List<Perfil> getPeticionesEmisorPorEstados(String idPerfilEmisor, EstadoPeticion estado) {
		List<Peticion> resultadoEncontrado = repo.getPeticionesEmisorPorEstados(idPerfilEmisor, estado.name());
		List<Perfil> resultadoFinal = new ArrayList();
		for (Peticion perfil : resultadoEncontrado) {
			Perfil perfilEncontrado = serviPerfil.encontrarPerfilPorId(perfil.getIdPerfilReceptor());
			resultadoFinal.add(perfilEncontrado);

		}
		return resultadoFinal;

	}

	@Override
	public List<Perfil> getPeticionesReceptorPendientes(String idPerfilReceptor, EstadoPeticion estado) {
		List<Peticion> resultadoEncontrado = repo.getPeticionesReceptorPendientes(idPerfilReceptor, estado.name());
		List<Perfil> resultadoFinal = new ArrayList();
		for (Peticion perfil : resultadoEncontrado) {
			Perfil perfilEncontrado = serviPerfil.encontrarPerfilPorId(perfil.getIdPerfilEmisor());
			resultadoFinal.add(perfilEncontrado);

		}
		return resultadoFinal;

	}

	@Override 
	public Peticion hacerMatch(String idPerfilEmisor, String idPerfilReceptor) {
		Peticion peticionEmisor = repo.getPeticion(idPerfilEmisor, idPerfilReceptor, EstadoPeticion.CONTACTO.name());
		Peticion peticionReceptor = repo.getPeticion(idPerfilReceptor, idPerfilEmisor, EstadoPeticion.CONTACTO.name());

		if (isMatch(peticionEmisor, peticionReceptor)) {
			peticionEmisor.setEstado(EstadoPeticion.MATCH);
			peticionReceptor.setEstado(EstadoPeticion.MATCH);
			repo.save(peticionReceptor);
			return repo.save(peticionEmisor);
		} 
		return null;

	}

	private boolean isMatch(Peticion peticionEmisor, Peticion peticionReceptor) {
		return peticionEmisor != null 
				&& peticionReceptor != null 
				&& peticionEmisor.getIdPerfilEmisor().equals(peticionReceptor.getIdPerfilReceptor());
	}

}
