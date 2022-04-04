package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Cuenta;

@Transactional
@Repository
public class CuentaRepoImpl implements ICuentaRepo {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Cuenta buscarCuentaPorUsername(String username) {
		TypedQuery<Cuenta> mq = em.createQuery("SELECT c FROM Cuenta c WHERE c.username=:username", Cuenta.class);
		mq.setParameter("username", username);
		return mq.getSingleResult();
	}
	
	
	

}
