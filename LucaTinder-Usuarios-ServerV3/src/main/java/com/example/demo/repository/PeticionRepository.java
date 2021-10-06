package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Peticion;

@Repository
public interface PeticionRepository extends MongoRepository<Peticion, String> {
	@Query("{$and :[{idPerfilEmisor : ?0}, {estado : ?1}]}")
	public List<Peticion> getPeticionesEmisorPorEstados(String idPerfilEmisor, String estado);

	@Query("{$and :[{idPerfilReceptor : ?0}, {estado : ?1}]}")
	public List<Peticion> getPeticionesReceptorPendientes(String idPerfilReceptor, String estado);

	@Query("{$and :[{idPerfilEmisor : ?0}, {idPerfilReceptor : ?1}, {estado : ?2}]}")
	public Peticion getPeticion(String idPerfilEmisor, String idPerfilReceptor, String estado);
}
