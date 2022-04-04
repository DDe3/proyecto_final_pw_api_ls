package com.example.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta")
public class Cuenta {
	@Id
	@Column(name = "cuen_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cuenta")
	@SequenceGenerator(name = "seq_cuenta", sequenceName = "seq_cuenta", allocationSize = 1)
	private Integer id;

	@Column(name = "cuen_username", unique = true)
	private String username;
	@Column(name = "cuen_password")
	private String password;
	
	@OneToOne
	@MapsId
	private Cliente cliente;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

	

}
