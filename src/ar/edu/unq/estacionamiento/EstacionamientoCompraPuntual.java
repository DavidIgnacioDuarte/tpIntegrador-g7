package ar.edu.unq.estacionamiento;

import java.time.LocalTime;

public class EstacionamientoCompraPuntual extends Estacionamiento {
	private Integer horas;
	private LocalTime horaDeFin;
	
	public EstacionamientoCompraPuntual(String patente, LocalTime horaFinal) {
		super();
		this.setPatente(patente);
		this.setHoraFinal(horaFinal);
	}
	
	public void guardarEstacionamiento(String patente) {
		//TODO
	}	
	
	@Override
	public void terminarEstacionamiento(LocalTime hora) {
		
	}

	@Override
	public Boolean esVigente() {
		return null;
	}
}
