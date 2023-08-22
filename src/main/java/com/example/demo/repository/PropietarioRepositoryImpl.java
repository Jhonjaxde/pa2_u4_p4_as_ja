package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class PropietarioRepositoryImpl implements IPropietarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(value = TxType.MANDATORY)
	@Override
	public void insertar(Propietario propietario) {
		// TODO Auto-generated method stub
		// System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		this.entityManager.persist(propietario);
	}
	@Transactional(value = TxType.NOT_SUPPORTED)
	@Override
	public Propietario buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Propietario.class, id);
	}
	@Transactional(value = TxType.MANDATORY)
	@Override
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(propietario);
	}
	@Transactional(value = TxType.MANDATORY)
	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscarId(id));

	}
	@Transactional(value = TxType.NOT_SUPPORTED)
	@Override
	public List<Propietario> buscarTodos() {
		TypedQuery<Propietario> query = this.entityManager.createQuery("SELECT p FROM Propietario p ",
				Propietario.class);
		return query.getResultList();
	}

}