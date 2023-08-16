package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.IPropietarioRepository;
import com.example.demo.repository.modelo.Propietario;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PropietarioServiceImpl implements IPropietarioService {

	@Autowired
	private IPropietarioRepository propietarioRepository;

	//@Transactional(value = TxType.MANDATORY)
	@Override

	public void guardar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.propietarioRepository.insertar(propietario);

	}

	@Transactional(value = TxType.NOT_SUPPORTED)
	@Override
	public Propietario buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.buscarId(id);
	}

	@Transactional(value = TxType.MANDATORY)
	@Override
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.propietarioRepository.actualizar(propietario);
	}

	@Transactional(value = TxType.MANDATORY)
	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.propietarioRepository.eliminar(id);
	}

	@Transactional(value = TxType.NOT_SUPPORTED)
	@Override
	public List<Propietario> buscarTodos() {
		// TODO Auto-generated method stub
		return this.buscarTodos();
	}

}