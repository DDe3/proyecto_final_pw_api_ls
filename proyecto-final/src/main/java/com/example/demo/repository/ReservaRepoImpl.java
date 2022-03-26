package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Reserva;



@Repository
@Transactional
public class ReservaRepoImpl implements IReservaRepo {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void insertarReserva(Reserva reserva) {
		em.persist(reserva);
	}

	@Override
	public void actualizarReserva(Reserva reserva) {
		em.merge(reserva);
	}

	@Override
	public Reserva buscarReserva(String numero) {
		TypedQuery<Reserva> mq = em.createQuery("SELECT r FROM Reserva r WHERE r.numero=:numero", Reserva.class);
		mq.setParameter("numero", numero);
		return mq.getSingleResult();
	}

	@Override
	public List<Reserva> reporteReserva(LocalDate fechaInicio, LocalDate fechaFin) {
		// SELECT r FROM Reserva r WHERE :fechaInicio >= r.fechaInicio AND :fechaFin <= r.fechaFin
		TypedQuery<Reserva> mq = em.createQuery("SELECT r FROM Reserva r WHERE :fechaInicio <= r.fechaInicio AND :fechaFin >= r.fechaFin", Reserva.class);
		mq.setParameter("fechaInicio", fechaInicio);
		mq.setParameter("fechaFin", fechaFin);
		return mq.getResultList();
		
	}
	
	
	

}
