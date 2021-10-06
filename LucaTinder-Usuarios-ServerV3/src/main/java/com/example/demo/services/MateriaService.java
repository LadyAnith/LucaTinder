package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Materia;

public interface MateriaService {

	public List<Materia> listarMateria();

	public Materia guardar(Materia materia);

	public void eliminarMateriaPorId(String id);
}
