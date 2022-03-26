package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Cliente;




@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository {

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void insertarCliente(Cliente cliente) {
		this.em.persist(cliente);
	}

	@Override
	public Cliente buscarCliente(String cedula) {
		TypedQuery<Cliente> mq = em.createQuery("SELECT c FROM Cliente c WHERE c.cedula=:cedula", Cliente.class);
		mq.setParameter("cedula", cedula);
		return mq.getSingleResult();
	}

	@Override
	public List<Cliente> buscarTodos() {
		TypedQuery<Cliente> mq = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
		return mq.getResultList();
	}
	
	

}
