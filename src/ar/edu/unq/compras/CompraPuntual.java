package ar.edu.unq.compras;

import ar.edu.unq.zona.PuntoDeVenta;

public class CompraPuntual extends Compra {

	private Integer horasCompradas;
	
	
	public CompraPuntual(Integer numeroC, PuntoDeVenta puntoDeVenta, Integer cantidadHorasCompradas) {
		super(numeroC, puntoDeVenta);
		this.setHorasCompradas(cantidadHorasCompradas);
	}
	
	public Integer getHorasCompradas() {
		return horasCompradas;
	}
	
	public void setHorasCompradas(Integer horasCompradas) {
		this.horasCompradas = horasCompradas;
	}
	
}
