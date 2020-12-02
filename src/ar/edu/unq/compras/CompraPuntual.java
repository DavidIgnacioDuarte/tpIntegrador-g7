package ar.edu.unq.compras;

import java.time.LocalDate;
import java.time.LocalTime;

import ar.edu.unq.zona.PuntoDeVenta;

public class CompraPuntual extends Compra {

	private double horasCompradas;
	
	
	public CompraPuntual(Integer numeroC, LocalTime horaEfectuada, LocalDate fechaEfectuada, PuntoDeVenta puntoDeVenta, double cantidadHorasCompradas) {
		super(numeroC, horaEfectuada, fechaEfectuada, puntoDeVenta);
		this.setHorasCompradas(cantidadHorasCompradas);
	}
	
	public double getHorasCompradas() {
		return horasCompradas;
	}
	
	public void setHorasCompradas(double horasCompradas) {
		this.horasCompradas = horasCompradas;
	}
	
}
