package ar.edu.unq.estacionamiento;

import java.time.LocalTime;

public abstract class Estacionamiento {
	
	protected Boolean esActivo;
	protected String patente;
	protected LocalTime horaInicio;

	
	protected Estacionamiento(String patente) {
		super();
		this.setPatente(patente);
		this.setHoraInicio(LocalTime.now());
	}
	
//	public abstract LocalTime horaMaximaDeFin();
	protected abstract void finalizarEstacionamiento();
	protected abstract LocalTime horaMaximaFin();
	
	public Boolean esVigente() {
		return LocalTime.now().isBefore(this.horaMaximaFin());
	}
	
	
	public String getPatente() {
		return patente;
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
	
	public Boolean getEsActivo() {
		return esActivo;
	}
	public void setEsActivo(Boolean esActivo) {
		this.esActivo = esActivo;
	}
	
}
