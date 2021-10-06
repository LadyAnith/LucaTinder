package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Perfil;

public interface PerfilService {

	public List<Perfil> listarPerfiles();

	public Perfil encontrarPerfilPorId(String id);

	public Perfil guardar(Perfil perfil);

	public void deleteById(Perfil perfil);

	public Perfil actualizarPerfiles(Perfil perfil);
}
