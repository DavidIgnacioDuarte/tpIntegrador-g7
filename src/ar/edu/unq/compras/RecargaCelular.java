package ar.edu.unq.compras;

import ar.edu.unq.zona.PuntoDeVenta;

public class RecargaCelular extends Compra {
	
	private double montoARecargar;
	private long numeroDeCelularAsociado;
	
	
	public RecargaCelular(int numeroC, PuntoDeVenta puntoDeVenta, double montoRecargado, long numeroCelular) {
		super(numeroC, puntoDeVenta);
		this.setMontoARecargar(montoRecargado);
		this.setNumeroDeCelularAsociado(numeroCelular);
	}
	
	public void setMontoARecargar(double montoARecargar) {
		this.montoARecargar = montoARecargar;
	}

	public void setNumeroDeCelularAsociado(long numeroDeCelularAsociado) {
		this.numeroDeCelularAsociado = numeroDeCelularAsociado;
	}

	public double getMontoARecargar() {
		return montoARecargar;
	}
	public long getNumeroDeCelularAsociado() {
		return numeroDeCelularAsociado;
	}
	
}
