package ar.edu.unq.compras;

import ar.edu.unq.zona.PuntoDeVenta;

public class RecargaCelular extends Compra {
	
	private Double montoARecargar;
	private Long numeroDeCelularAsociado;
	
	
	public RecargaCelular(Integer numeroC, PuntoDeVenta puntoDeVenta, Double montoRecargado, Long numeroCelular) {
		super(numeroC, puntoDeVenta);
		this.setMontoARecargar(montoRecargado);
		this.setNumeroDeCelularAsociado(numeroCelular);
	}
	
	public void setMontoARecargar(Double montoARecargar) {
		this.montoARecargar = montoARecargar;
	}

	public void setNumeroDeCelularAsociado(Long numeroDeCelularAsociado) {
		this.numeroDeCelularAsociado = numeroDeCelularAsociado;
	}

	public Double getMontoARecargar() {
		return montoARecargar;
	}
	public Long getNumeroDeCelularAsociado() {
		return numeroDeCelularAsociado;
	}
	
}
