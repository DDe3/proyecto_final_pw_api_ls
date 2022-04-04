package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.demo.repository.IVehiculoRepo;
import com.example.demo.repository.modelo.Reserva;
import com.example.demo.repository.modelo.Vehiculo;

class VehiculoServiceTest {

	@Test
	void estaDisponible1() {
		VehiculoServiceImpl vs = new VehiculoServiceImpl();
		List<Reserva> reservaciones = new ArrayList<>();
		Reserva r = new Reserva();
		r.setFechaInicio(LocalDate.parse("2022-04-04"));
		r.setFechaFin(LocalDate.parse("2022-04-06"));
		reservaciones.add(r);
		String response = 
				vs.estaDisponible(
						LocalDate.parse("2022-04-05"), 
						LocalDate.parse("2022-04-05"), reservaciones);
		assertEquals("No Disponible", response);
	}
	
	@Test
	void estaDisponible2() {
		VehiculoServiceImpl vs = new VehiculoServiceImpl();
		List<Reserva> reservaciones = new ArrayList<>();
		Reserva r = new Reserva();
		r.setFechaInicio(LocalDate.parse("2022-04-05"));
		r.setFechaFin(LocalDate.parse("2022-04-06"));
		reservaciones.add(r);
		String response = 
				vs.estaDisponible(
						LocalDate.parse("2022-04-07"), 
						LocalDate.parse("2022-04-08"), reservaciones);
		assertEquals("Disponible", response);
	}
	
	@Test
	void estaDisponible3() {
		VehiculoServiceImpl vs = new VehiculoServiceImpl();
		List<Reserva> reservaciones = new ArrayList<>();
		Reserva r = new Reserva();
		r.setFechaInicio(LocalDate.parse("2022-04-01"));
		r.setFechaFin(LocalDate.parse("2022-04-06"));
		reservaciones.add(r);
		String response = 
				vs.estaDisponible(
						LocalDate.parse("2022-04-04"), 
						LocalDate.parse("2022-04-09"), reservaciones);
		assertEquals("No Disponible", response);
	}
	
	@Test
	void estaDisponible4() {
		VehiculoServiceImpl vs = new VehiculoServiceImpl();
		List<Reserva> reservaciones = new ArrayList<>();
		Reserva r = new Reserva();
		r.setFechaInicio(LocalDate.parse("2022-04-06"));
		r.setFechaFin(LocalDate.parse("2022-04-09"));
		reservaciones.add(r);
		String response = 
				vs.estaDisponible(
						LocalDate.parse("2022-04-02"), 
						LocalDate.parse("2022-04-06"), reservaciones);
		assertEquals("No Disponible", response);
	}
	
	@Test
	void estaDisponible5() {
		VehiculoServiceImpl vs = new VehiculoServiceImpl();
		List<Reserva> reservaciones = new ArrayList<>();
		Reserva r = new Reserva();
		r.setFechaInicio(LocalDate.parse("2022-04-07"));
		r.setFechaFin(LocalDate.parse("2022-04-08"));
		reservaciones.add(r);
		String response = 
				vs.estaDisponible(
						LocalDate.parse("2022-04-01"), 
						LocalDate.parse("2022-04-06"), reservaciones);
		assertEquals("Disponible", response);
	}
	
	
	@Test
	void dawsBetween1() {
		VehiculoServiceImpl vs = new VehiculoServiceImpl();
		Long response = vs.daysBetween(LocalDate.parse("2022-04-01"), LocalDate.parse("2022-04-06"));
		assertEquals(5, response);
	}
	
	@Test
	void dawsBetween2() {
		VehiculoServiceImpl vs = new VehiculoServiceImpl();
		Long response = vs.daysBetween(LocalDate.parse("2022-04-01"), LocalDate.parse("2022-04-01"));
		assertEquals(1, response);
	}
	
	@Test
	void dawsBetween3() {
		VehiculoServiceImpl vs = new VehiculoServiceImpl();
		Long response = vs.daysBetween(LocalDate.parse("2022-04-05"), LocalDate.parse("2022-04-01"));
		assertEquals(1, response);
	}
	
	
	@Test
	void dawsBetween4() {
		VehiculoServiceImpl vs = new VehiculoServiceImpl();
		Long response = vs.daysBetween(LocalDate.parse("2000-01-05"), LocalDate.parse("2022-12-01"));
		assertEquals(8366, response);
	}
	
	@Test
	void verificarVehiculo1() {
		IVehiculoRepo vrepo = Mockito.mock(IVehiculoRepo.class);
		VehiculoServiceImpl vs = new VehiculoServiceImpl(vrepo);
		Vehiculo v = new Vehiculo();
		v.setPlaca("123");
		v.setEstado("Disponible");
		Reserva r = new Reserva();
		r.setFechaInicio(LocalDate.parse("2022-04-06"));
		r.setFechaFin(LocalDate.parse("2022-04-09"));
		List<Reserva> reservas = new ArrayList<Reserva>();
		reservas.add(r);
		v.setReservaciones(reservas);
		
		
		when(vrepo.buscarVehiculoPorPlaca("123")).thenReturn(v);
		String response = vs.verificarVehiculo("123", LocalDate.parse("2022-12-01"), LocalDate.parse("2022-12-01"));
		
		assertEquals("Disponible", response);
		
	}
	
	
	@Test
	void verificarVehiculo2() {
		IVehiculoRepo vrepo = Mockito.mock(IVehiculoRepo.class);
		VehiculoServiceImpl vs = new VehiculoServiceImpl(vrepo);
		Vehiculo v = new Vehiculo();
		v.setPlaca("123");
		v.setEstado("No disponible");
		v.setReservaciones(new ArrayList<>());
		
		when(vrepo.buscarVehiculoPorPlaca("123")).thenReturn(v);
		String response = vs.verificarVehiculo("123", LocalDate.parse("2022-12-01"), LocalDate.parse("2022-12-01"));
		
		assertEquals("Disponible", response);
		
	}
	
	@Test
	void verificarVehiculo3() {
		IVehiculoRepo vrepo = Mockito.mock(IVehiculoRepo.class);
		VehiculoServiceImpl vs = new VehiculoServiceImpl(vrepo);
		Vehiculo v = new Vehiculo();
		v.setPlaca("123");
		v.setEstado("No disponible");
		v.setReservaciones(new ArrayList<>());
		
		when(vrepo.buscarVehiculoPorPlaca("123")).thenReturn(null);
		String response = vs.verificarVehiculo("123", LocalDate.parse("2022-12-01"), LocalDate.parse("2022-12-01"));
		
		assertEquals(null, response);
		
	}
	
	

}
