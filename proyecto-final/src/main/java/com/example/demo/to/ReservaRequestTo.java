package com.example.demo.to;

public class ReservaRequestTo {
	
	private String placa;
	private String cedula; 
	private String fechaInicio;
	private String fechaFin;
	private String numeroTarjeta;
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	@Override
	public String toString() {
		return "ReservaRequestTo [placa=" + placa + ", cedula=" + cedula + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", numeroTarjeta=" + numeroTarjeta + "]";
	}
	
	

	
}
