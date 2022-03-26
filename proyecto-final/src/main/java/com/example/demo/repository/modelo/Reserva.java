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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_reserva")
	@SequenceGenerator(name = "seq_reserva", sequenceName = "seq_reserva", allocationSize = 1)
	@Column(name = "rese_id")
	private Integer id;
	@Column(name = "rese_numero")
	private String numero;
	@Column(name = "rese_fecha_inicio")
	private LocalDate fechaInicio;
	@Column(name = "rese_fecha_fin")
	private LocalDate fechaFin;
	@Column(name = "rese_valor_subtotal")
	private Double valorSubtotal;
	@Column(name = "rese_valor_iva")
	private Double valorIVA;
	@Column(name = "rese_valor_total")
	private Double valorTotalAPagar;
	@Column(name = "rese_estado")
	private String estado;
	
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "vehi_id")
    private Vehiculo vehiculo;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "clie_id")
	private Cliente cliente;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "reserva")
	private Factura factura;

	
	
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getValorSubtotal() {
		return valorSubtotal;
	}

	public void setValorSubtotal(Double valorSubtotal) {
		this.valorSubtotal = valorSubtotal;
	}

	public Double getValorIVA() {
		return valorIVA;
	}

	public void setValorIVA(Double valorIVA) {
		this.valorIVA = valorIVA;
	}

	public Double getValorTotalAPagar() {
		return valorTotalAPagar;
	}

	public void setValorTotalAPagar(Double valorTotalAPagar) {
		this.valorTotalAPagar = valorTotalAPagar;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", numero=" + numero + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", valorSubtotal=" + valorSubtotal + ", valorIVA=" + valorIVA + ", valorTotalAPagar="
				+ valorTotalAPagar + ", estado=" + estado;
	}
	
	
	
	
	

}
