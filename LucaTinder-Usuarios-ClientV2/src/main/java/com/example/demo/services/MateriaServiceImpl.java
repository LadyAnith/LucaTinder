package com.example.demo.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Materia;

@Service
public class MateriaServiceImpl implements MateriaService{
	
	RestTemplate plantilla = new RestTemplate();

	@Override
	public List<Materia> listarMateria() {
		ResponseEntity<Materia[]> respuesta = plantilla.getForEntity("http://localhost:2222/materias/all",
				Materia[].class);
		List<Materia> materias = Arrays.asList(respuesta.getBody());
		return materias;
	}
	
	@Override
	public Materia guardar(Materia materia) {
		return null;
	}

	@Override
	public void eliminarMateriaPorId(String id) {
		;
		
	}

}
