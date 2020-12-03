package ar.edu.unq.compras;

import java.time.LocalDate;
import java.time.LocalTime;

import ar.edu.unq.zona.PuntoDeVenta;

public abstract class Compra {
	
	private Integer numeroDeControl;
	private LocalTime horaEfectuada;
	private LocalDate fechaEfectuada;
	private PuntoDeVenta puntoDeVenta;
	
	
	public Compra(Integer numeroC, PuntoDeVenta puntoDeVenta) {
		this.setNumeroDeControl(numeroDeControl);
		this.setHoraEfectuada(LocalTime.now());
		this.setFechaEfectuada(LocalDate.now());
		this.setPuntoDeVenta(puntoDeVenta);
	}
	
	public int getNumeroDeControl() {
		return numeroDeControl;
	}
	
	public void setNumeroDeControl(int numeroDeControl) {
		this.numeroDeControl = numeroDeControl;
	}

	public LocalTime getHoraEfectuada() {
		return horaEfectuada;
	}


	public void setHoraEfectuada(LocalTime horaEfectuada) {
		this.horaEfectuada = horaEfectuada;
	}


	public LocalDate getFechaEfectuada() {
		return fechaEfectuada;
	}


	public void setFechaEfectuada(LocalDate fechaEfectuada) {
		this.fechaEfectuada = fechaEfectuada;
	}
	
	public PuntoDeVenta getPuntoDeVenta() {
		return puntoDeVenta;
	}
	
	public void setPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
		this.puntoDeVenta = puntoDeVenta;
	}
	
}
