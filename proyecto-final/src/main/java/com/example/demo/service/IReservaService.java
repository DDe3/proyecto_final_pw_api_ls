package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Reserva;
import com.example.demo.to.ReservaReporteTo;
import com.example.demo.to.ReservaTo;
import com.example.demo.to.RetirarRequestTo;

public interface IReservaService {
	
	void insertarReserva(Reserva reserva);
	void actualizarReserva(Reserva reserva);
	Reserva buscarReserva(String numero);
	RetirarRequestTo buscarReservaRequest(String numero);
	List<ReservaReporteTo> reporteReservas(String fechaInicio, String fechaFin);
	ReservaTo buscarReservaRetirar(String numero);
	
}
