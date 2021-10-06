package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Perfil;

@Repository
public interface PerfilRepositorio extends MongoRepository <Perfil, String>{

}
