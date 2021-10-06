package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Perfil;
import com.example.demo.repository.PerfilRepositorio;

@Service
public class PerfilServicesImpl implements PerfilServices{

	@Autowired
	PerfilRepositorio repo;


	@Override
	public List<Perfil> listarPerfil() {
		return repo.findAll();
	}

	@Override
	public Perfil encontrarPerfilPorId(String id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Perfil guardar(Perfil perfil) {
		return repo.save(perfil);
	}

	@Override
	public void eliminarPerfilPorId(String id) {
		repo.deleteById(id);

	}

	@Override
	public Optional<Perfil> actualizarPerfil(Perfil perfil) {

		Perfil usuarioViejo = repo.findById(perfil.getId()).orElse(null);

		Optional<Perfil> result = Optional.ofNullable(usuarioViejo);

		return result;

	}

}
