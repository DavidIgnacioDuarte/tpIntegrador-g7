package ar.edu.unq.estacionamiento;

import java.time.LocalTime;

public class EstacionamientoCompraPuntual extends Estacionamiento {
	
	private Integer horas;
	private LocalTime horaFinal;
	
	public void setHoraFinal(LocalTime hora) {
		horaFinal = hora;
	}
	
	public EstacionamientoCompraPuntual(String patente, Integer horas) {
		super();
		this.setPatente(patente);
		this.setHoraFinal(horaFinal);
	}
	
	public void guardarEstacionamiento(String patente) {
		//TODO
	}	
	
	@Override
	public void finalizarEstacionamiento() {
		this.setEsActivo(false);
	}

}
