package ar.edu.unq.app;
import ar.edu.unq.tools.*;
import ar.edu.unq.zona.*;

import java.time.LocalTime;

import ar.edu.unq.estacionamiento.EstacionamientoApp;
import ar.edu.unq.sem.SEM;

public class AppUsuario implements MovementSensor, CambioDeZona{
	private Long nroCelular;
	private String patente;
	private AppStrategy modo;
	// private boolean isDriving;
	private Zona zonaActualParado;
	
	public AppUsuario(Long nroCelular, String patente) {
		this.patente = patente;
		this.nroCelular = nroCelular;
	}

	public void walking() {
		modo.walking(this);
	}

	public void driving() {
		modo.driving(this);
	}
	
	public void iniciarEstacionamiento() {
		SEM.getSEM().agregarEstacionamiento(new EstacionamientoApp(patente));
	}
	
	public void finalizarEstacionamiento() {
		SEM.getSEM().finalizarEstacionamiento(nroCelular);
	}
	
	public Double consultarSaldo() {
		return SEM.getSEM().getSistemaDeAsociaciones().consultarSaldo(nroCelular);
	}

	public Long getNroCelular() {
		return nroCelular;
	}
	
	@Override
	public void cambiarZona(Zona zona) {
		this.zonaActualParado = zona;
	}


	@Override
	public void salirDeZona() {
		this.zonaActualParado = null;
	}
	

}
