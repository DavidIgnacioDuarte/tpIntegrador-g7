package ar.edu.unq.estacionamiento;

import java.time.LocalTime;

public abstract class Estacionamiento {

	protected String patente;
	protected LocalTime horaInicio;

	
	protected Estacionamiento(String patente) {
		super();
		this.setPatente(patente);
		this.setHoraInicio(LocalTime.now());
	}

	protected abstract LocalTime horaMaximaFin();
	
	public Boolean esVigente() {
		return LocalTime.now().isBefore(this.horaMaximaFin());
	}
	
	
	public String getPatente() {
		return this.patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	
}
