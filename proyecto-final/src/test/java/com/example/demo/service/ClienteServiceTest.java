package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.demo.repository.IClienteRepository;
import com.example.demo.repository.ICuentaRepo;
import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.Reserva;
import com.example.demo.to.ClienteVIP;

class ClienteServiceTest {

	@Test
	void listarVip1() {
		IClienteRepository repo1 = Mockito.mock(IClienteRepository.class);
		ICuentaRepo repo2 = Mockito.mock(ICuentaRepo.class);
		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente = new Cliente();
		cliente.setCedula("1");
		cliente.setNombre("2");
		cliente.setApellido("3");
		cliente.setReservaciones(new ArrayList<>());
		clientes.add(cliente);
		when(repo1.buscarTodos()).thenReturn(clientes);
		
		
		ClienteServiceImpl service = new ClienteServiceImpl(repo1, repo2);
		
		List<ClienteVIP> cvips = service.listarVIP();
		
		assertEquals(new ArrayList<ClienteVIP>(), cvips);
	}
	
	@Test
	void listarVip2() {
		IClienteRepository repo1 = Mockito.mock(IClienteRepository.class);
		ICuentaRepo repo2 = Mockito.mock(ICuentaRepo.class);
		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente = new Cliente();
		cliente.setCedula("1");
		cliente.setNombre("2");
		cliente.setApellido("3");
		
		
		Reserva re1 = new Reserva();
		re1.setValorIVA(20.0);
		re1.setValorTotalAPagar(40.0);
		
		Reserva re2 = new Reserva();
		re2.setValorIVA(10.0);
		re2.setValorTotalAPagar(20.0);
		
		List<Reserva> reservas = new ArrayList<>();
		reservas.add(re1);
		reservas.add(re2);
		cliente.setReservaciones(reservas);
		
		clientes.add(cliente);
		when(repo1.buscarTodos()).thenReturn(clientes);
		
		
		ClienteServiceImpl service = new ClienteServiceImpl(repo1, repo2);
		
		List<ClienteVIP> cvips = service.listarVIP();

		assertEquals(cvips.get(0).getValorIVA(), 30.0);
	}
	
	@Test
	void listarVip3() {
		IClienteRepository repo1 = Mockito.mock(IClienteRepository.class);
		ICuentaRepo repo2 = Mockito.mock(ICuentaRepo.class);
		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente = new Cliente();
		cliente.setCedula("1");
		cliente.setNombre("2");
		cliente.setApellido("3");
		
		
		Reserva re1 = new Reserva();
		re1.setValorIVA(20.0);
		re1.setValorTotalAPagar(40.0);
		
		Reserva re2 = new Reserva();
		re2.setValorIVA(10.0);
		re2.setValorTotalAPagar(20.0);
		
		List<Reserva> reservas = new ArrayList<>();
		reservas.add(re1);
		reservas.add(re2);
		cliente.setReservaciones(reservas);
		
		clientes.add(cliente);
		when(repo1.buscarTodos()).thenReturn(clientes);
		
		
		ClienteServiceImpl service = new ClienteServiceImpl(repo1, repo2);
		
		List<ClienteVIP> cvips = service.listarVIP();

		assertEquals(cvips.get(0).getValorTotal(), 60.0);
	}
	
	
	@Test
	void listarVip4() {
		IClienteRepository repo1 = Mockito.mock(IClienteRepository.class);
		ICuentaRepo repo2 = Mockito.mock(ICuentaRepo.class);
		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente = new Cliente();
		cliente.setCedula("1");
		cliente.setNombre("2");
		cliente.setApellido("3");
		
		
		Reserva re1 = new Reserva();
		re1.setValorIVA(20.0);
		re1.setValorTotalAPagar(40.0);
		
		Reserva re2 = new Reserva();
		re2.setValorIVA(10.0);
		re2.setValorTotalAPagar(20.0);
		
		List<Reserva> reservas = new ArrayList<>();
		reservas.add(re1);
		reservas.add(re2);
		cliente.setReservaciones(reservas);
		
		clientes.add(cliente);
		when(repo1.buscarTodos()).thenReturn(clientes);
		
		ClienteServiceImpl service = new ClienteServiceImpl(repo1, repo2);
		
		List<ClienteVIP> cvips = service.listarVIP();

		assertEquals(cvips.get(0).getValorTotal(), 60.0);
	}
	
	@Test
	void listarVip5() {
		IClienteRepository repo1 = Mockito.mock(IClienteRepository.class);
		ICuentaRepo repo2 = Mockito.mock(ICuentaRepo.class);
		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente = new Cliente();
		cliente.setCedula("1");
		cliente.setNombre("2");
		cliente.setApellido("3");
		
		
		Reserva re1 = new Reserva();
		re1.setValorIVA(20.0);
		re1.setValorTotalAPagar(40.0);
		
		Reserva re2 = new Reserva();
		re2.setValorIVA(10.0);
		re2.setValorTotalAPagar(20.0);
		
		List<Reserva> reservas = new ArrayList<>();
		reservas.add(re1);
		reservas.add(re2);
		cliente.setReservaciones(reservas);
		
		clientes.add(cliente);
		
		
		Cliente cliente2 = new Cliente();
		cliente2.setCedula("1");
		cliente2.setNombre("2");
		cliente2.setApellido("3");
		
		
		Reserva re3 = new Reserva();
		re3.setValorIVA(5.0);
		re3.setValorTotalAPagar(20.0);
		
		Reserva re4 = new Reserva();
		re4.setValorIVA(5.0);
		re4.setValorTotalAPagar(20.0);
		
		List<Reserva> reservas2 = new ArrayList<>();
		reservas2.add(re3);
		reservas2.add(re4);
		cliente2.setReservaciones(reservas2);
		
		clientes.add(cliente2);
		
		
		
		when(repo1.buscarTodos()).thenReturn(clientes);
		
		ClienteServiceImpl service = new ClienteServiceImpl(repo1, repo2);
		
		List<ClienteVIP> cvips = service.listarVIP();
		System.out.println(cvips);

		assertEquals(60, cvips.get(0).getValorTotal());
	}
	
	@Test
	void listarVip6() {
		IClienteRepository repo1 = Mockito.mock(IClienteRepository.class);
		ICuentaRepo repo2 = Mockito.mock(ICuentaRepo.class);
		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente = new Cliente();
		cliente.setCedula("1");
		cliente.setNombre("2");
		cliente.setApellido("3");
		
		
		Reserva re1 = new Reserva();
		re1.setValorIVA(20.0);
		re1.setValorTotalAPagar(40.0);
		
		Reserva re2 = new Reserva();
		re2.setValorIVA(10.0);
		re2.setValorTotalAPagar(20.0);
		
		List<Reserva> reservas = new ArrayList<>();
		reservas.add(re1);
		reservas.add(re2);
		cliente.setReservaciones(reservas);
		
		clientes.add(cliente);
		
		
		Cliente cliente2 = new Cliente();
		cliente2.setCedula("1");
		cliente2.setNombre("2");
		cliente2.setApellido("3");
		
		
		Reserva re3 = new Reserva();
		re3.setValorIVA(5.0);
		re3.setValorTotalAPagar(20.0);
		
		Reserva re4 = new Reserva();
		re4.setValorIVA(5.0);
		re4.setValorTotalAPagar(20.0);
		
		List<Reserva> reservas2 = new ArrayList<>();
		reservas2.add(re3);
		reservas2.add(re4);
		cliente2.setReservaciones(reservas2);
		
		clientes.add(cliente2);
		
		
		
		when(repo1.buscarTodos()).thenReturn(clientes);
		
		ClienteServiceImpl service = new ClienteServiceImpl(repo1, repo2);
		
		List<ClienteVIP> cvips = service.listarVIP();

		assertEquals(40.0, cvips.get(1).getValorTotal());
	}
	
	
	
	
	
	
	

}
