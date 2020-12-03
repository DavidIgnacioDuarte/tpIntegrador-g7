package ar.edu.unq.app;

import ar.edu.unq.tools.*;
import ar.edu.unq.zona.*;

import java.time.LocalTime;

import ar.edu.unq.sem.SEM;

public class AppUsuario implements MovementSensor, CambioDeZona{
	private long nroCelular;
	private String patente;
	private AppStrategy modo;
	private boolean isDriving; // ???
	private Zona zonaActualParado;

	public void walking() {
		modo.walking();
	}

	public void driving() {
		modo.driving();
	}
	
	public void iniciarEstacionamiento() {
		SEM.getSEM().agregarEstacionamiento(estacionamiento);
	}
	
	public void finalizarEstacionamiento() {
		SEM.getSEM().terminarEstacionamiento(nroCelular, LocalTime.now());
	}
	
	public double consultarSaldo() {
		return SEM.getSEM().getSistemaDeSaldos().consultarSaldo(nroCelular);
	}

	@Override
	public void cambiarZona(Zona zona) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salirDeZona() {
		// TODO Auto-generated method stub
		
	}
	

}
