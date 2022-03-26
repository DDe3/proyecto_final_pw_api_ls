package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import com.example.demo.controller.ClienteRestController;
import com.example.demo.repository.IClienteRepository;
import com.example.demo.repository.modelo.Cliente;
import com.example.demo.to.ClienteTo;
import com.example.demo.to.ClienteVIP;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private IClienteRepository repository;

	@Override
	public void insertarCliente(ClienteTo cliente) {
		repository.insertarCliente(mapClienteTo(cliente));
	}
	
	
	
	private Cliente mapClienteTo(ClienteTo cto) {
		Cliente c = new Cliente();
		c.setCedula(cto.getCedula());
		c.setNombre(cto.getNombre());
		c.setApellido(cto.getApellido());
		c.setFechaNacimiento(LocalDate.parse(cto.getFechaNacimiento()));
		c.setGenero(cto.getGenero());
		c.setRegistro(cto.getRegistro());
		c.setReservaciones(new ArrayList<>());
		return c;
	}



	@Override
	public ClienteTo buscarClientePorCedula(String cedula) {
		Cliente c = repository.buscarCliente(cedula);
		ClienteTo ret = mapCliente(c);
		return ret;
	}
	
	private ClienteTo mapCliente(Cliente cto) {
		ClienteTo c = new ClienteTo();
		c.setCedula(cto.getCedula());
		c.setNombre(cto.getNombre());
		c.setApellido(cto.getApellido());
		c.setFechaNacimiento(cto.getFechaNacimiento().toString());
		c.setGenero(cto.getGenero());
		c.setRegistro(cto.getRegistro());
		return c;
	}



	@Override
	public Cliente buscarClienteEntidadPorCedula(String cedula) {
		return repository.buscarCliente(cedula);
	}



	@Override
	public List<ClienteVIP> listarVIP() {
		List<Cliente> clientes = repository.buscarTodos();
		List<ClienteVIP> clientesVIP = clientes.stream().filter(c->!c.getReservaciones().isEmpty()).map(c -> mapClienteToVIP(c)).collect(Collectors.toList());
		Collections.sort(clientesVIP);
		return clientesVIP;
	}
	
	private ClienteVIP mapClienteToVIP(Cliente c) {
		ClienteVIP cv = new ClienteVIP();
		cv.setCedula(c.getCedula());
		cv.setNombre(c.getNombre());
		cv.setApellido(c.getApellido());
		Double ivaTotal = c.getReservaciones().stream().mapToDouble(r -> r.getValorIVA()).sum();
		Double valorTotal = c.getReservaciones().stream().mapToDouble(r -> r.getValorTotalAPagar()).sum();
		cv.setValorIVA(ivaTotal);
		cv.setValorTotal(valorTotal);
		Link myLink = linkTo( methodOn(ClienteRestController.class).buscarCliente(c.getCedula()) ).withRel("link");
		cv.add(myLink);
		return cv;
		
	}
	
	

}
