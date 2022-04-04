package com.example.demo.repository.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "vehiculo")
public class Vehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vehiculo")
	@SequenceGenerator(name = "seq_vehiculo", sequenceName = "seq_vehiculo", allocationSize = 1)
	@Column(name="vehi_id")
	private Integer id;
	@Column(name="vehi_placa", unique = true)
	private String placa;
	@Column(name="vehi_modelo")
	private String modelo;
	@Column(name="vehi_marca")
	private String marca;
	@Column(name="vehi_fecha_fabricacion")
	private LocalDate fechaFabricacion;
	@Column(name = "vehi_pais_fabricacion")
	private String paisFabricacion;
	@Column(name="vehi_cilindraje")
	private Double cilindraje;
	@Column(name="vehi_precio")
	private Double precio;
	@Column(name="vehi_valor_dia")
	private Double valorDia;
	@Column(name="vehi_estado")
	private String estado;
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculo")
	private List<Reserva> reservaciones;
	
	public List<Reserva> getReservaciones() {
		return reservaciones;
	}
	
	

	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getPaisFabricacion() {
		return paisFabricacion;
	}



	public void setPaisFabricacion(String paisFabricacion) {
		this.paisFabricacion = paisFabricacion;
	}



	public void setReservaciones(List<Reserva> reservaciones) {
		this.reservaciones = reservaciones;
	}

	public void addReserva(Reserva reserva) {
		this.reservaciones.add(reserva);
		reserva.setVehiculo(this);
	}
	
	public void removeReserva(Reserva reserva) {
		reservaciones.remove(reserva);
		reserva.setVehiculo(null);
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
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
	

	public LocalDate getFechaFabricacion() {
		return fechaFabricacion;
	}

	public void setFechaFabricacion(LocalDate fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
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
	public Double getValorDia() {
		return valorDia;
	}
	public void setValorDia(Double valorDia) {
		this.valorDia = valorDia;
	}
	
	
	
	
	

}
