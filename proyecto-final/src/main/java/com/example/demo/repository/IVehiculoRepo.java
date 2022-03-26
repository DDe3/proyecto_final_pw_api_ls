package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Vehiculo;

public interface IVehiculoRepo {
	
	Vehiculo buscarVehiculoPorPlaca(String placa);
	List<Vehiculo> buscarVehiculoPorMyM(String marca, String modelo);
	void insertarVehiculo(Vehiculo vehiculo);
	void actualizarVehiculo(Vehiculo vehiculo);
	
	

}
