package ar.edu.unq.estacionamiento;

import java.time.LocalTime;

public abstract class Estacionamiento {
	private Long nroTelefono;
	private String patente;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	
	public abstract Boolean esVigente();
	public abstract void terminarEstacionamiento(LocalTime hora);

	public Long getNroTelefono() {
		return nroTelefono;
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
	
	public void setHoraFinal(LocalTime hora) {
		horaFin = hora;
	}
}
