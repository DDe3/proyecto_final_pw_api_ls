package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Cliente;

public interface IClienteRepository {
	
	void insertarCliente(Cliente cliente);
	Cliente buscarCliente(String cedula);
	List<Cliente> buscarTodos();

}
