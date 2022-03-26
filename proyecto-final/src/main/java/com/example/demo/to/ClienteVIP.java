package com.example.demo.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class ClienteVIP extends RepresentationModel<ClienteVIP> implements Serializable, Comparable<ClienteVIP> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cedula;
	private String nombre;
	private String apellido;
	private Double valorIVA;
	private Double valorTotal;
	
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Double getValorIVA() {
		return valorIVA;
	}
	public void setValorIVA(Double valorIVA) {
		this.valorIVA = valorIVA;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	@Override
	public int compareTo(ClienteVIP o) {
		return (int) (o.getValorTotal() - this.valorTotal);
	}
	
	

}
