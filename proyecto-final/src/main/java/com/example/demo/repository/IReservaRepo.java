package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.repository.modelo.Reserva;

public interface IReservaRepo {
	
	void insertarReserva(Reserva reserva);
	void actualizarReserva(Reserva reserva);
	Reserva buscarReserva(String numero);
	List<Reserva> reporteReserva(LocalDate fechaInicio, LocalDate fechaFin);
	

}
