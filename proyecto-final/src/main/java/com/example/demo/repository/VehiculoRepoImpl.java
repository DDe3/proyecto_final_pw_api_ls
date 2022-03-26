package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Vehiculo;

@Transactional
@Repository
public class VehiculoRepoImpl implements IVehiculoRepo {
	
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public Vehiculo buscarVehiculoPorPlaca(String placa) {
		TypedQuery<Vehiculo> mq = em.createQuery("SELECT v FROM Vehiculo v WHERE v.placa=:placa", Vehiculo.class);
		mq.setParameter("placa", placa);
		return mq.getSingleResult();
	}

	@Override
	public List<Vehiculo> buscarVehiculoPorMyM(String marca, String modelo) {
		TypedQuery<Vehiculo> mq = em.createQuery("SELECT v FROM Vehiculo v WHERE v.marca=:marca AND v.modelo=:modelo", Vehiculo.class);
		mq.setParameter("marca", marca);
		mq.setParameter("modelo", modelo);
		return mq.getResultList();
	}

	@Override
	public void actualizarVehiculo(Vehiculo vehiculo) {
		em.merge(vehiculo);
	}

	@Override
	public void insertarVehiculo(Vehiculo vehiculo) {
		em.persist(vehiculo);
	}
	
	

}
