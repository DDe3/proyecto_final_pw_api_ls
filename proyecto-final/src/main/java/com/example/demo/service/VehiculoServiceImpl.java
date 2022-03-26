package com.example.demo.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IReservaRepo;
import com.example.demo.repository.IVehiculoRepo;
import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.Factura;
import com.example.demo.repository.modelo.Reserva;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.to.RetirarRequestTo;
import com.example.demo.to.VehiculoTo;
import com.example.demo.to.VehiculosFiltradoTo;



@Service
public class VehiculoServiceImpl implements IVehiculoService {
	
	public static final Double IVA = 0.12;
	
	@Autowired
	private IVehiculoRepo vehiculoRepo;
	
	@Autowired
	private IReservaService reservaService;
	
	@Autowired
	private IClienteService clienteService;

	@Override
	public String reservarVehiculo(String placa, String cedula, String fechaInicio, String fechaFin, String numeroTarjeta) {
		
		LocalDate inicio = LocalDate.parse(fechaInicio);
		LocalDate fin = LocalDate.parse(fechaFin);
		String estado = verificarVehiculo(placa, inicio, fin);
		if (estado=="No Disponible") {
			return "Este vehículo ya está reservado de: " + fechaFin + " a: " +fechaFin;
		} else {
			Vehiculo v = vehiculoRepo.buscarVehiculoPorPlaca(placa);
			Reserva reserva = new Reserva();
			reserva.setFechaInicio(inicio);
			reserva.setFechaFin(fin);
			
			Double subtotal = (double) (daysBetween(inicio, fin) * v.getValorDia());
			Double valorIVA = (double) (subtotal*IVA);
			Double valorTotal = (double) (subtotal + valorIVA);
			
			reserva.setValorSubtotal(subtotal);
			reserva.setValorIVA(valorIVA);
			reserva.setValorTotalAPagar(valorTotal);
			String numero = String.valueOf(UUID.randomUUID());
			reserva.setNumero(numero);
			reserva.setEstado("Generada");
			
			Factura factura = registrarCobro(valorTotal, numeroTarjeta, reserva);
			reserva.setFactura(factura);
			Cliente c = clienteService.buscarClienteEntidadPorCedula(cedula);
			reserva.setCliente(c);
			
			v.addReserva(reserva);
			
			vehiculoRepo.actualizarVehiculo(v);
			return numero;
		}
		
		
		
		
	}
	
	@Override
	public void insertarVehiculo(VehiculoTo vt) {
		Vehiculo v = mapVehiculoTo(vt);
		vehiculoRepo.insertarVehiculo(v);
	}
	
	private Factura registrarCobro(Double cobro, String numeroTarjeta, Reserva reserva) {
		Factura f = new Factura();
		f.setCobro(cobro);
		f.setNumeroTarjeta(numeroTarjeta);
		f.setFechaCobro(LocalDate.now());
		f.setReserva(reserva);
		f.setReservaNumero(reserva.getNumero());
		return f;
	}
	
	
	
	private String verificarVehiculo(String placa, LocalDate fechaInicio, LocalDate fechaFin) {
		Vehiculo v = vehiculoRepo.buscarVehiculoPorPlaca(placa);
		return estaDisponible(fechaInicio, fechaFin, v.getReservaciones());
	}
	
//	
//	private VehiculoTo mapVehiculo(Vehiculo v, LocalDate fechaInicio, LocalDate fechaFin) {
//		if (v!=null) {
//			VehiculoTo vt = new VehiculoTo();
//			vt.setPlaca(v.getPlaca());
//			vt.setModelo(v.getModelo());
//			vt.setMarca(v.getMarca());
//			vt.setFechaFabricacion(v.getFechaFabricacion().toString());
//			vt.setPaisFabricacion(v.getPaisFabricacion());
//			vt.setCilindraje(v.getCilindraje());
//			vt.setPrecio(v.getPrecio());
//			vt.setValorDia(v.getValorDia());
//			vt.setEstado(estaDisponible(fechaInicio, fechaFin, v.getReservaciones()));
//			return vt;
//		}
//		return null;
//	}
	
	private String estaDisponible(LocalDate fechaInicio, LocalDate fechafin, List<Reserva> reservaciones) {
		if (reservaciones.isEmpty()) {
			return "Disponible";
		} else {
			for (Reserva r : reservaciones) {
				if ( !fechaInicio.isBefore(r.getFechaInicio()) && !fechaInicio.isAfter(r.getFechaFin()) ) {  //Esta dentro de ese campo
					return "No Disponible";
				} 
				if ( !fechafin.isBefore(r.getFechaInicio()) && !fechafin.isAfter(r.getFechaFin())) { //Esta dentro de ese campo
					return "No Disponible";
				}
				
			}
			return "Disponible";
		}
		
	}
	
	private Long daysBetween(LocalDate fechaInicio, LocalDate fechaFin) {
		long noOfDaysBetween = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
		if (noOfDaysBetween>0) {
			return noOfDaysBetween;
		} else {
			return (long) 1;
		}
	}
	
	private Vehiculo mapVehiculoTo(VehiculoTo vto) {
		Vehiculo v = new Vehiculo();
		v.setPlaca(vto.getPlaca());
		v.setModelo(vto.getModelo());
		v.setMarca(vto.getMarca());
		v.setFechaFabricacion(LocalDate.parse(vto.getFechaFabricacion()));
		v.setPaisFabricacion(vto.getPaisFabricacion());
		v.setCilindraje(vto.getCilindraje());
		v.setPrecio(vto.getPrecio());
		v.setValorDia(vto.getValorDia());
		v.setReservaciones(new ArrayList<>());
		v.setEstado(vto.getEstado());
		return v;
		
	}

	@Override
	public VehiculoTo buscarVehiculoPorPlaca(String placa) {
		Vehiculo v = vehiculoRepo.buscarVehiculoPorPlaca(placa);
		return mapearVehiculo(v);
	}
	
	private VehiculoTo mapearVehiculo(Vehiculo v) {
		VehiculoTo vt = new VehiculoTo();
		vt.setPlaca(v.getPlaca());
		vt.setModelo(v.getModelo());
		vt.setMarca(v.getMarca());
		vt.setFechaFabricacion(v.getFechaFabricacion().toString());
		vt.setPaisFabricacion(v.getPaisFabricacion());
		vt.setCilindraje(v.getCilindraje());
		vt.setPrecio(v.getPrecio());
		vt.setValorDia(v.getValorDia());
		vt.setEstado(v.getEstado());
		return vt;
	}
	

	@Override
	public List<VehiculosFiltradoTo> buscarVehiculoPorMyM(String marca, String modelo) {
		List<Vehiculo> v = vehiculoRepo.buscarVehiculoPorMyM(marca,modelo);
		List<VehiculosFiltradoTo> ret = new ArrayList<>();
		for (Vehiculo vehiculo : v) {
			ret.add(mapVehiculoToFiltrado(vehiculo));
		}
		return ret;
	}

	@Override
	public String retirarVehiculo(String numero) {
		Reserva r = reservaService.buscarReserva(numero);
		Vehiculo v = r.getVehiculo();
		v.setEstado("No Disponible");
		r.setEstado("Ejecutada");
		vehiculoRepo.actualizarVehiculo(v);
		return null;
	}
	
	
	private VehiculosFiltradoTo mapVehiculoToFiltrado(Vehiculo v) {
		VehiculosFiltradoTo vf = new VehiculosFiltradoTo();
		vf.setPlaca(v.getPlaca());
		vf.setModelo(v.getModelo());
		vf.setMarca(v.getMarca());
		vf.setFechaFabricacion(v.getFechaFabricacion().toString());
		vf.setEstado(v.getEstado());
		vf.setValorPorDia(v.getValorDia());
		return vf;
	}
	
	

}
