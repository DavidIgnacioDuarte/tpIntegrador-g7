package ar.edu.unq.compras;

import java.time.LocalDate;
import java.time.LocalTime;

import ar.edu.unq.zona.PuntoDeVenta;

public class CompraPuntual extends Compra {

	private Integer horasCompradas;
	
	
	public CompraPuntual(Integer numeroC, LocalTime horaEfectuada, LocalDate fechaEfectuada, PuntoDeVenta puntoDeVenta, Integer cantidadHorasCompradas) {
		super(numeroC, horaEfectuada, fechaEfectuada, puntoDeVenta);
		this.setHorasCompradas(cantidadHorasCompradas);
	}
	
	public Integer getHorasCompradas() {
		return horasCompradas;
	}
	
	public void setHorasCompradas(Integer horasCompradas) {
		this.horasCompradas = horasCompradas;
	}
	
}
