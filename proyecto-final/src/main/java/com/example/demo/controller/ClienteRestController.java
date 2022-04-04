package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IClienteService;
import com.example.demo.to.ClienteTo;
import com.example.demo.to.ClienteVIP;
import com.example.demo.to.CuentaTo;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteRestController {
	
	@Autowired
	private IClienteService service;
	
	
	
	public ClienteRestController(IClienteService service) {
		this.service = service;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertarCliente(@RequestBody ClienteTo cto) {
		return ResponseEntity.ok(service.insertarCliente(cto));
	}
	
	@GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteTo> buscarCliente(@PathVariable("cedula") String cedula) {
		return ResponseEntity.ok(service.buscarClientePorCedula(cedula));
	}
	
	@GetMapping(path = "/vip", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClienteVIP>> listarVIP() {
		return ResponseEntity.ok(service.listarVIP());
	}
	
	@GetMapping(path = "/auth/{username}")
	public ResponseEntity<CuentaTo> auth(@PathVariable("username") String username) {
		return ResponseEntity.ok(service.buscarClientePorUsername(username));
	}
	
}
