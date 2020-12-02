package ar.edu.unq.estacionamiento;

import java.time.LocalTime;

public abstract class Estacionamiento {
	
	protected String patente;
	protected LocalTime horaInicio;
	protected LocalTime horaMaxFin;
//	protected Boolean esActivo;

	
	public Boolean esVigente() {
		return LocalTime.now().isBefore(this.getHoraMaxFin()) && this.getEsActivo();
	}
	
	public abstract void finalizarEstacionamiento();
	
	
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
	
	public void setHoraMaxFin(LocalTime horaMaxFin) {
		this.horaMaxFin = horaMaxFin;
	}
	public LocalTime getHoraMaxFin() {
		return this.horaMaxFin;
	}
	
	public Boolean getEsActivo() {
		return esActivo;
	}
	public void setEsActivo(Boolean esActivo) {
		this.esActivo = esActivo;
	}
	
}
