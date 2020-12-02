package ar.edu.unq.compras;

import java.time.LocalDate;
import java.time.LocalTime;

import com.sun.tools.javac.code.Source.Feature;

import ar.edu.unq.zona.PuntoDeVenta;

public class RecargaCelular extends Compra {
	
	private double montoARecargar;
	private long numeroDeCelularAsociado;
	
	
	public RecargaCelular(int numeroC, LocalTime horaEfectuada, LocalDate fechaEfectuada, PuntoDeVenta puntoDeVenta, double montoRecargado, long numeroCelular) {
		super(numeroC, horaEfectuada, fechaEfectuada, puntoDeVenta);
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
