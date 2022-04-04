package com.example.demo.repository;

import com.example.demo.repository.modelo.Cuenta;

public interface ICuentaRepo {
	
	Cuenta buscarCuentaPorUsername(String username);

}
