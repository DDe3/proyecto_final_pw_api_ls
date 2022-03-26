package com.example.demo.service;

import java.util.List;

import com.example.demo.to.VehiculoTo;
import com.example.demo.to.VehiculosFiltradoTo;

public interface IVehiculoService {
	
	String reservarVehiculo(String placa, String cedula, String fechaInicio, String fechaFin, String numeroTarjeta);
	void insertarVehiculo(VehiculoTo v);
	VehiculoTo buscarVehiculoPorPlaca(String placa);
	List<VehiculosFiltradoTo> buscarVehiculoPorMyM(String marca, String modelo);
	String retirarVehiculo(String numero);
}
