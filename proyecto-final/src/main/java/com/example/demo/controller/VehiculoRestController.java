package com.example.demo.controller;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IVehiculoService;
import com.example.demo.to.ReservaRequestTo;
import com.example.demo.to.VehiculoTo;
import com.example.demo.to.VehiculosFiltradoTo;

@RestController
@RequestMapping("/api/v1/vehiculos")
public class VehiculoRestController {
	
	@Autowired
	private IVehiculoService service;
	
	
	@PostMapping(path = "/reservaciones", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> reservarVehiculo(@RequestBody ReservaRequestTo req) {
		return ResponseEntity.ok(service.reservarVehiculo(req.getPlaca(), req.getCedula(),  req.getFechaInicio(), req.getFechaFin(), req.getNumeroTarjeta()));
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertarVehiculo(@RequestBody VehiculoTo vhto) {
		vhto.setEstado("Disponible");
		service.insertarVehiculo(vhto);
		return ResponseEntity.ok("Vehiculo registrado con exito!");
	}
	
	@GetMapping(path = "/{placa}")
	public ResponseEntity<VehiculoTo> buscarVehiculoPorPlaca(@PathVariable("placa") String placa) {
		return ResponseEntity.ok(service.buscarVehiculoPorPlaca(placa));
	}
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VehiculosFiltradoTo>> buscarVehiculoPorMyM(@PathParam(value = "marca") String marca, @PathParam(value = "modelo") String modelo) {
		return ResponseEntity.ok(service.buscarVehiculoPorMyM(marca, modelo));
	}
	
	@PutMapping(path = "/{numeroReserva}")
	public ResponseEntity<String> retirarVehiculo(@PathVariable("numeroReserva") String numeroReserva) {
		service.retirarVehiculo(numeroReserva);
		return ResponseEntity.ok("Reserva ejecutada. Vehiculo retirado");
	}
	
	@PutMapping(path = "/reservaciones/sin-reservacion")
	public ResponseEntity<String> retirarVehiculoSinReserva(@RequestBody ReservaRequestTo req) {
		String numeroReserva = service.reservarVehiculo(req.getPlaca(), req.getCedula(),  req.getFechaInicio(), req.getFechaFin(), req.getNumeroTarjeta());
		System.out.println(numeroReserva);
		if (numeroReserva.startsWith("Este")) {
			return ResponseEntity.ok("Este vehiculo ya esta reservado para la fecha de: "+req.getFechaInicio()+" a "+req.getFechaFin());
		} else {
			service.retirarVehiculo(numeroReserva);
			return ResponseEntity.ok("Vehiculo reservado y retirado");
		}
		
	}
	
}
