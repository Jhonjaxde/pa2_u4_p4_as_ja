package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.IPropietarioService;

@Controller
//buena practica en singular
@RequestMapping("/propietarios")
public class PropietarioController {
	
	@Autowired
	private IPropietarioService iPropietarioService;
	// el controler recibe la peticion
	
	// y redirecciona una vista 
	//http://localhost:8080/consesionario/propietarios/buscar
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		List<Propietario> lista = this.iPropietarioService.buscarTodos();
		modelo.addAttribute("propietarios",lista);
		return "vistaListaPropietario";
	}
	//http://localhost:8080/consesionario/propietarios/buscarPorID/1
	@GetMapping("/buscarPorID/{idPropietario}")
	public String buscaPorId(@PathVariable("idPropietario")Integer id,Model modelo) {
		Propietario prop= this.iPropietarioService.buscarId(id);
		modelo.addAttribute("propietario",prop);
		return "vistaPropietario";
		
	}
	//no boy enviar un modelo, sino el objeto
	@PutMapping("/actualizar/{idPropietario}")
	public String actualizarPropietario(@PathVariable("idPropietario")Integer id ,Propietario propietario) {
		this.iPropietarioService.actualizar(propietario);
		return "redirect:/propietarios/buscar";
	}
}
