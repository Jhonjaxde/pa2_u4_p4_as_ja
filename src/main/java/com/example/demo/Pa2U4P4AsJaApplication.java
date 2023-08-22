package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.IPropietarioService;

@SpringBootApplication
public class Pa2U4P4AsJaApplication implements CommandLineRunner{
	@Autowired
	private IPropietarioService service;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U4P4AsJaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Propietario p = new Propietario();
		p.setApellido("Salazar");
		p.setCedula("89321");
		p.setNombre("Augusto");
		
		Propietario p1 = new Propietario();
		p1.setApellido("Arteaga");
		p1.setCedula("73712");
		p1.setNombre("Jhon");
		
		
		
		List<Propietario> lista = new ArrayList<>();
		lista.add(p);
		lista.add(p1);
		//
		//this.service.guardar(p1);
		
		
		//this.service.buscarTodos();
		//this.iPropietarioService.buscarId(1);
		
	}

}
