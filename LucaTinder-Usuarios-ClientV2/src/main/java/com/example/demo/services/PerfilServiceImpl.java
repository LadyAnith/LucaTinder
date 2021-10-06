package com.example.demo.services;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Perfil;

@Service
public class PerfilServiceImpl implements PerfilService {

	RestTemplate plantilla = new RestTemplate();

	@Override
	public List<Perfil> listarPerfiles() {
		ResponseEntity<List<Perfil>> respuesta = plantilla.exchange("http://localhost:2222/perfiles/all",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Perfil>>() {
				});
		List<Perfil> perfiles = respuesta.getBody();
		return perfiles;
	}

//	@Override
//	public Optional<Usuario> encontrarUsuarioPorId(String id, Usuario usuario) {
//		return plantilla.en("http://localhost:2222/usuarios/" + usuario.getId());
//	}

	@Override
	public Perfil guardar(Perfil perfil) {
		HttpEntity<Perfil> peticion = new HttpEntity<>(perfil);
		return plantilla.postForObject("http://localhost:2222/perfiles/add", peticion, Perfil.class);
	}

	@Override
	public void deleteById(Perfil perfil) {
		plantilla.delete("http://localhost:2222/perfiles/" + perfil.getId());

	}

	@Override
	public Perfil actualizarPerfiles(Perfil perfil) {
		String URI_USERS_ID = "http://localhost:2222/perfiles/" + perfil.getId();
		System.out.println("++++++++++++++++++++++" + perfil);
		plantilla.put(URI_USERS_ID, perfil);
		return perfil;
	}

	@Override
	public Perfil encontrarPerfilPorId(String idPerfil) {
		// TODO Auto-generated method stub
		return plantilla.getForObject("http://localhost:2222/perfiles/" + idPerfil, Perfil.class);
	}

}
