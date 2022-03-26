package com.example.demo.repository.modelo;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "factura")
public class Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_factura")
	@SequenceGenerator(name = "seq_factura", sequenceName = "seq_factura", allocationSize = 1)
	@Column(name="fact_id")
	private Integer id;
	@Column(name="fact_cobro")
	private Double cobro;
	@Column(name="fact_numero_tarjeta")
	private String numeroTarjeta;
	@Column(name="fact_fecha_cobro")
	private LocalDate fechaCobro;

	@OneToOne 
	@MapsId
	private Reserva reserva;
	
	
	
	
	public Reserva getReserva() {
		return reserva;
	}


	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}


	private String reservaNumero;
	
	


	public String getReservaNumero() {
		return reservaNumero;
	}


	public void setReservaNumero(String reservaNumero) {
		this.reservaNumero = reservaNumero;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Double getCobro() {
		return cobro;
	}


	public void setCobro(Double cobro) {
		this.cobro = cobro;
	}


	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}


	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}


	public LocalDate getFechaCobro() {
		return fechaCobro;
	}


	public void setFechaCobro(LocalDate fechaCobro) {
		this.fechaCobro = fechaCobro;
	}
	






	
	

}
