package ar.edu.unq.app;
import ar.edu.unq.tools.*;
import ar.edu.unq.zona.*;

import ar.edu.unq.estacionamiento.EstacionamientoApp;
import ar.edu.unq.sem.SEM;

public class AppUsuario implements MovementSensor, CambioDeZona{
	private Long nroCelular;
	private String patente;
	private AppStrategy modo;
	private Boolean asistenciaAlUsuario;
	private Zona zonaActualParado;
	private String ultimaNotificacion;
	
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
	
	public void setModo(AppStrategy modo) {
		this.modo = modo;
	}
	
	public void iniciarEstacionamiento() {
		SEM.getSEM().getSistemaDeAsociaciones().agregarAlSistemaDePatentes(this.nroCelular,this.patente);
		SEM.getSEM().agregarEstacionamiento(new EstacionamientoApp(patente));
	}
	
	public void finalizarEstacionamiento() {
		SEM.getSEM().finalizarEstacionamiento(nroCelular);
	}
	
	public Double consultarSaldo() {
		return SEM.getSEM().getSistemaDeAsociaciones().consultarSaldo(nroCelular);
	}

	public Long getNroCelular() {
		return this.nroCelular;
	}
	
	public void activarAsistenciaAlUsuario() {
		this.asistenciaAlUsuario = true;
	}
	
	public void desactivarAsistenciaAlUsuario() {
		this.asistenciaAlUsuario = false;
	}
	
	public Boolean estaActivaAsistenciaAlUsuario() {
		return asistenciaAlUsuario;
	}
	
	public Boolean hayEstacionamientoEnCurso() {
		return SEM.getSEM().esVigente(patente);
	}
	
	@Override
	public void cambiarZona(Zona zona) {
		this.zonaActualParado = zona;
	}


	@Override
	public void salirDeZona() {
		this.zonaActualParado = null;
	}

	public Zona getZonaActualParado() {
		return zonaActualParado;
	}

	public Boolean estaEnZonaValida() {
		return this.zonaActualParado != null;
	}

	public void notificar(String notificacion) {
		this.ultimaNotificacion = notificacion;
	}

	public String getUltimaNotificacion() {
		return ultimaNotificacion;
	}

}
