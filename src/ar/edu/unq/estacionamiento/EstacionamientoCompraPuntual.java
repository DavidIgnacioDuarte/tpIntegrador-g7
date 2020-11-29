package ar.edu.unq.estacionamiento;

import java.time.LocalTime;

public class EstacionamientoCompraPuntual extends Estacionamiento {
	private Integer horas;
	private LocalTime horaDeFin;
	
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
