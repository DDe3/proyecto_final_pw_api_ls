package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Reserva;
import com.example.demo.service.IReservaService;
import com.example.demo.to.ReservaReporteTo;

@RestController
@RequestMapping("/api/v1/clientes/reservaciones")
public class ReservasRestController {
	
	@Autowired
	private IReservaService service;
	
	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReservaReporteTo>> reporteReservas(@PathParam(value = "fechaInicio") String fechaInicio, @PathParam(value = "fechaFin") String fechaFin) {
		return ResponseEntity.ok(service.reporteReservas(fechaInicio, fechaFin));
	}
	
	@GetMapping(path = "/{numReserva}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Reserva> getReserva(@PathVariable("numReserva") String numReserva) {
		return ResponseEntity.ok(service.buscarReserva(numReserva));
	}
	
	
}
