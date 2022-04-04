package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import com.example.demo.controller.ReservasRestController;
import com.example.demo.repository.IReservaRepo;
import com.example.demo.repository.modelo.Reserva;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.to.ReservaReporteTo;
import com.example.demo.to.ReservaTo;
import com.example.demo.to.RetirarRequestTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;




@Service
public class ReservaServiceImpl implements IReservaService {
	
	@Autowired
	private IReservaRepo reservaRepo;

	@Override
	public void insertarReserva(Reserva reserva) {
		reservaRepo.insertarReserva(reserva);
	}

	@Override
	public void actualizarReserva(Reserva reserva) {
		reservaRepo.actualizarReserva(reserva);
	}

	@Override
	public Reserva buscarReserva(String numero) {
		return reservaRepo.buscarReserva(numero);
	}
	

	@Override
	public RetirarRequestTo buscarReservaRequest(String numero) {
		Reserva r = buscarReserva(numero);
		RetirarRequestTo ret = new RetirarRequestTo();
		Vehiculo v = r.getVehiculo();
		ret.setPlaca(v.getPlaca());
		ret.setModelo(v.getModelo());
		ret.setEstado(v.getEstado());
		ret.setFechaInicio(r.getFechaInicio().toString());
		ret.setFechaFin(r.getFechaFin().toString());
		ret.setCedula(r.getCliente().getCedula());
		return ret;
	}

	@Override
	public List<ReservaReporteTo> reporteReservas(String fechaInicio, String fechaFin) {
		List<Reserva> reservas = reservaRepo.reporteReserva(LocalDate.parse(fechaInicio), LocalDate.parse(fechaFin));
		return reservas.stream().map( r -> attachLink(r)).collect(Collectors.toList());
	}
	
	
	private ReservaReporteTo attachLink(Reserva reserva) {
		ReservaReporteTo rrto = new ReservaReporteTo();
		rrto.setNumero(reserva.getNumero());
		rrto.setFechaInicio(reserva.getFechaInicio().toString());
		rrto.setFechaFin(reserva.getFechaFin().toString());
		rrto.setValorTotalAPagar(reserva.getValorTotalAPagar());
		rrto.setEstado(reserva.getEstado());
		rrto.setNombreCliente(reserva.getCliente().getNombre() + " " + reserva.getCliente().getApellido());
		rrto.setCedulaCliente(reserva.getCliente().getCedula());
		rrto.setPlacaVehiculo(reserva.getVehiculo().getPlaca());
		rrto.setMarcaVehiculo(reserva.getVehiculo().getMarca());
		rrto.setModeloVehiculo(reserva.getVehiculo().getModelo());
		Link myLink = linkTo(methodOn(ReservasRestController.class).getReserva(rrto.getNumero())).withRel("link");
		rrto.add(myLink);
		return rrto;
	}

	@Override
	public ReservaTo buscarReservaRetirar(String numero) {
		Reserva r = buscarReserva(numero);
		ReservaTo rto = new ReservaTo();
		Vehiculo v = r.getVehiculo();
		rto.setPlaca(v.getPlaca());
		rto.setModelo(v.getModelo());
		rto.setEstado(v.getEstado());
		rto.setFecha(r.getFechaInicio().toString() + " - " + r.getFechaFin().toString());
		rto.setCedula(r.getCliente().getCedula());
		return rto;
	}
	

}
