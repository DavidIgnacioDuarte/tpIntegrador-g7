package ar.edu.unq.zona;

import java.time.LocalTime;

import ar.edu.unq.estacionamiento.EstacionamientoCompraPuntual;
import ar.edu.unq.sem.SEM;

public class PuntoDeVenta {
	
	public void recargarCelular(Long nroCelular, Double credito) {
		//TODO
	}
	
	public void iniciarEstacionamiento(String patente, LocalTime horaFinal) {
		this.validarHora(horaFinal);
		SEM.getSEM().agregarEstacionamiento(new EstacionamientoCompraPuntual(patente, horaFinal)); // Modificar Singleton con el SEM;
	}
	
	private void validarHora(LocalTime horaFinal) {
		//TODO
	}
}
