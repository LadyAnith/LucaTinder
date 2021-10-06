package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.services.MateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	@Autowired
	private MateriaService service;

//	@GetMapping("/list")
//	public String listMateriaFront(Model m) {
//		m.addAttribute("materiaListFront", service.listarMateria());
//		return "FrontPerfilForm";
//	}
}
