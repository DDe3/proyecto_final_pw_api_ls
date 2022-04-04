package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.Cuenta;
import com.example.demo.service.IClienteService;
import com.example.demo.to.ClienteTo;

class ClienteRestControllerTest {

	@Test
	void insertarCliente() {
		
		
		IClienteService service = Mockito.mock(IClienteService.class);
		
		ClienteTo cliente = new ClienteTo();
		cliente.setCedula("1125875511");
		cliente.setNombre("Test");
		cliente.setApellido("Cliente");
		cliente.setFechaNacimiento("1997-05-05");
		cliente.setGenero('M');
		cliente.setRegistro('T');
		cliente.setUsername("usernametest");
		cliente.setPassword("passwordtest");
		
		when(service.insertarCliente(cliente)).thenReturn("Cliente registrado");
		ClienteRestController controller = new ClienteRestController(service);
		
		ResponseEntity<String> respuesta = controller.insertarCliente(cliente);
		String check = respuesta.getBody();
		assertEquals("Cliente registrado", check);
	}
	
	@Test
	void buscarClientePorCedula() {
		List<ClienteTo> clientes = new ArrayList<>();
		ClienteTo c = new ClienteTo();
		c.setNombre("Andy");
		c.setCedula("1725875569");
		
		ClienteTo c2 = new ClienteTo();
		c2.setNombre("Pedro");
		c2.setCedula("1725875566");
		
		clientes.add(c);
		clientes.add(c2);
		
		
		IClienteService service = Mockito.mock(IClienteService.class);
		when(service.buscarClientePorCedula("1725875569")).thenReturn(clientes.stream().filter(cli->cli.getCedula()=="1725875569").collect(Collectors.toList()).get(0));
		
		
		ClienteRestController controller = new ClienteRestController(service);
		ClienteTo response = controller.buscarCliente("1725875569").getBody();
		assertEquals("Andy", response.getNombre());
		
	}
	

}
