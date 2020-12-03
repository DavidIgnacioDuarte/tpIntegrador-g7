package ar.edu.unq.zona;

import java.time.LocalTime;

import ar.edu.unq.estacionamiento.EstacionamientoCompraPuntual;
import ar.edu.unq.sem.SEM;

public class PuntoDeVenta {
	
	public void recargarCelular(Long nroCelular, Double credito) {
		SEM.getSEM().getSistemaDeSaldos().recargarSaldo(nroCelular, credito);
	}
	
	public void iniciarEstacionamiento(String patente, Integer horas) {
		this.validarHora(horas);
		SEM.getSEM().agregarEstacionamiento(new EstacionamientoCompraPuntual(patente, horas)); // Modificar Singleton con el SEM;
	}
	
	private void validarHora(Integer horas) {
		//TODO
	}
}
