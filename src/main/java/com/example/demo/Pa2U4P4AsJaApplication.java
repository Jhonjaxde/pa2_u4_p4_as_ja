package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.IPropietarioService;

@SpringBootApplication
public class Pa2U4P4AsJaApplication implements CommandLineRunner {
	@Autowired
	private IPropietarioService iPropietarioService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U4P4AsJaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Propietario p = new Propietario();
		p.setApellido("Arteaga");
		p.setCedula("1727");
		p.setNombre("jhon");
		//this.iPropietarioService.guardar(p);
		
	}

}
