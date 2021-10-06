package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Perfil;
import com.example.demo.services.MateriaService;
import com.example.demo.services.PerfilService;

@Controller
@RequestMapping("/perfiles")
public class PefilController {
	@Autowired
	private PerfilService service;
	
	@Autowired
	private MateriaService materiaService;

	
	@GetMapping("/list")
	public String listPerfilFront(Model m) {
		m.addAttribute("perfilListFront", service.listarPerfiles());
		return "FrontPerfilList";
	}
	
	@GetMapping("getPerfil/{idPerfil}")
	public String getPerfil(Model m, @PathVariable String idPerfil) {
		m.addAttribute("perfilUsuario", service.encontrarPerfilPorId(idPerfil));
		return "FrontPerfilUser";
	}
	


//	 CREAR JUEGO
	@RequestMapping("/new")
	public String newPerfil(Perfil perfil, Model m) {
		m.addAttribute("materiaListFront", materiaService.listarMateria());

		return "FrontPerfilForm";
	}

	// GUARDAR JUEGO TRAS MODIFICACIÓN/ALTA
	@PostMapping("/add")
	public ModelAndView savePerfil(Perfil perfil) {
		service.guardar(perfil);
		return new ModelAndView("redirect:/perfiles/list");
	}
	
	

	@GetMapping("/edit")
	public String editPerfil(Perfil perfil, Model m) {
		System.out.println("------------------------------------------" + perfil);
		Perfil p = service.actualizarPerfiles(perfil);
		m.addAttribute("perfil", p);
		System.out.println("******************" + p);
		return "FrontPerfilForm";
	}

	// BORRAR USUARIOS
	@GetMapping("/delete")
	public String deletePerfil(Perfil perfil) {
		service.deleteById(perfil);
		return ("redirect:/perfiles/list");
	}
}
