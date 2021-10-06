package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Perfil;

public interface PerfilServices {

	public List<Perfil> listarPerfil();

	public Perfil encontrarPerfilPorId(String id);

	public Perfil guardar(Perfil perfil);

	public void eliminarPerfilPorId(String id);

	public Optional<Perfil> actualizarPerfil(Perfil perfil);
}
