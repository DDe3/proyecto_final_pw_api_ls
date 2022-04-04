package com.example.demo.to;

import java.time.LocalDate;
import java.util.List;


import com.example.demo.repository.modelo.Reserva;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ClienteTo {
	
	private String cedula;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private Character genero;
	private Character registro;
	private String username;
	private String password;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
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

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Character getGenero() {
		return genero;
	}
	public void setGenero(Character genero) {
		this.genero = genero;
	}
	public Character getRegistro() {
		return registro;
	}
	public void setRegistro(Character registro) {
		this.registro = registro;
	}

	
	
	

}
