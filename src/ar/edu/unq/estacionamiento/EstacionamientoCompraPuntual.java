package ar.edu.unq.estacionamiento;

import java.time.LocalTime;

import ar.edu.unq.compras.CompraPuntual;

public class EstacionamientoCompraPuntual extends Estacionamiento {

	private CompraPuntual habilitacionCompra;

	
	public EstacionamientoCompraPuntual(String patente, CompraPuntual habilitacionCompra) {
		super(patente);
		this.setHabilitacionCompra(habilitacionCompra);
	}
	
	@Override
	public LocalTime horaMaximaFin() {
		return this.getHoraInicio().minusHours(this.habilitacionCompra.getHorasCompradas()); 
	}
	
	public CompraPuntual getHabilitacionCompra() {
		return habilitacionCompra;
	}
	public void setHabilitacionCompra(CompraPuntual habilitacionCompra) {
		this.habilitacionCompra = habilitacionCompra;
	}
	
}
