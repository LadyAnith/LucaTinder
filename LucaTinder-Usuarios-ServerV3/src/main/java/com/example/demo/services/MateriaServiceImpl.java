package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Materia;
import com.example.demo.repository.MateriaRepositorio;

@Service
public class MateriaServiceImpl implements MateriaService{
	
	@Autowired
	MateriaRepositorio repo;

	@Override
	public List<Materia> listarMateria() {
		return repo.findAll();
	}

	@Override
	public Materia guardar(Materia materia) {
		return repo.save(materia);
	}

	@Override
	public void eliminarMateriaPorId(String id) {
		repo.deleteById(id);
		
	}

}
