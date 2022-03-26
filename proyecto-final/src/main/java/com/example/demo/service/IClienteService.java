package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.to.ClienteTo;
import com.example.demo.to.ClienteVIP;


public interface IClienteService {
	
	void insertarCliente(ClienteTo cliente);
	ClienteTo buscarClientePorCedula(String cedula);
	Cliente buscarClienteEntidadPorCedula(String cedula);
	List<ClienteVIP> listarVIP();


}
