package com.example.demo.to;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;

import org.springframework.hateoas.RepresentationModel;

public class ReservaReporteTo extends RepresentationModel<ReservaReporteTo> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String numero;
	private String fechaInicio;
	private String fechaFin;
	private Double valorTotalAPagar;
	private String estado;
	
	private String nombreCliente;
	private String cedulaCliente;
	
	private String placaVehiculo;
	private String marcaVehiculo;
	private String modeloVehiculo;
	
	
	
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getCedulaCliente() {
		return cedulaCliente;
	}
	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	public String getPlacaVehiculo() {
		return placaVehiculo;
	}
	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}
	public String getMarcaVehiculo() {
		return marcaVehiculo;
	}
	public void setMarcaVehiculo(String marcaVehiculo) {
		this.marcaVehiculo = marcaVehiculo;
	}
	public String getModeloVehiculo() {
		return modeloVehiculo;
	}
	public void setModeloVehiculo(String modeloVehiculo) {
		this.modeloVehiculo = modeloVehiculo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Double getValorTotalAPagar() {
		return valorTotalAPagar;
	}
	public void setValorTotalAPagar(Double valorTotalAPagar) {
		this.valorTotalAPagar = valorTotalAPagar;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
