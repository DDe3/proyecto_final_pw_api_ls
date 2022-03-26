package com.example.demo.to;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.example.demo.repository.modelo.Reserva;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class VehiculoTo extends RepresentationModel<VehiculoTo> implements Serializable {
	

	private String placa;
	private String modelo;
	private String marca;
	private String fechaFabricacion;
	private String paisFabricacion;
	private Double cilindraje;
	private Double precio;
	private Double valorDia;
	private String estado;
	

	public String getPlaca() {
		return placa;
	}
	
	

	public String getPaisFabricacion() {
		return paisFabricacion;
	}



	public void setPaisFabricacion(String paisFabricacion) {
		this.paisFabricacion = paisFabricacion;
	}



	public Double getCilindraje() {
		return cilindraje;
	}



	public void setCilindraje(Double cilindraje) {
		this.cilindraje = cilindraje;
	}



	public Double getPrecio() {
		return precio;
	}



	public void setPrecio(Double precio) {
		this.precio = precio;
	}



	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	

	public String getFechaFabricacion() {
		return fechaFabricacion;
	}



	public void setFechaFabricacion(String fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}



	public Double getValorDia() {
		return valorDia;
	}

	public void setValorDia(Double valorDia) {
		this.valorDia = valorDia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	
	
	

}
