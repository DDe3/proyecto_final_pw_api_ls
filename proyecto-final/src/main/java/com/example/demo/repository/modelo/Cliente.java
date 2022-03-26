package com.example.demo.repository.modelo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table( name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
	@SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente", allocationSize = 1)
	@Column(name="clie_id")
	private Integer id;
	@Column(name="clie_cedula")
	private String cedula;
	@Column(name="clie_nombre")
	private String nombre;
	@Column(name="clie_apellido")
	private String apellido;
	@Column(name="clie_fecha_nacimiento")
	private LocalDate fechaNacimiento;
	@Column(name="clie_genero")
	private Character genero;
	@Column(name="clie_registro")
	private Character registro;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private List<Reserva> reservaciones;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente")
	private UsuarioEntidad cuenta;
	
	public UsuarioEntidad getCuenta() {
		return cuenta;
	}

	public void setCuenta(UsuarioEntidad cuenta) {
		this.cuenta = cuenta;
	}

	public List<Reserva> getReservaciones() {
		return reservaciones;
	}

	public void setReservaciones(List<Reserva> reservaciones) {
		this.reservaciones = reservaciones;
	}

	public void addReserva(Reserva reserva) {
		this.reservaciones.add(reserva);
	}
	
	public void removeReserva(Reserva reserva) {
		reservaciones.remove(reserva);
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
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
