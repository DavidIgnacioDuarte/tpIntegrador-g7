package ar.edu.unq.estacionamiento;

import java.time.LocalTime;
import java.util.HashMap;

import ar.edu.unq.sem.SEM;

public class EstacionamientoApp extends Estacionamiento {

	private Long nroTelefono;
	
	
	public EstacionamientoApp(String patente) {
		super(patente);
		this.setNroTelefono(SEM.getSEM().getSistemaDeCelulares().getCelularAsociadoA(patente));
	}
	
	@Override
	public void finalizarEstacionamiento() {
			SEM.getSEM().getSistemaDeCelulares().descontarSaldo(this.getNroTelefono(), this.costoActual());
			SEM.getSEM().finalizarEstacionamiento(this);
	}
	
	@Override
	public LocalTime horaMaximaFin() {
		Double saldo = SEM.getSEM().getSistemaDeCelulares().getSaldoAsociadoA(this.nroTelefono);
		Long saldoPorSegundos = (long)(saldo * 3600 / SEM.getSEM().getPrecioPorHora());
		LocalTime horaMax = LocalTime.now().plusSeconds(saldoPorSegundos);
		return horaMax;
	}
	
	private Double costoActual() {
		Integer tiempoACobrarEnSegundos = LocalTime.now().toSecondOfDay() - this.getHoraInicio().toSecondOfDay();
		Double precioPorSegundo = SEM.getSEM().getPrecioPorHora() / 3600;
		Double costo = tiempoACobrarEnSegundos * precioPorSegundo;
		return costo;
	}
	
	
	public Long getNroTelefono() {
		return nroTelefono;
	}
	public void setNroTelefono(Long nroTelefono) {
		this.nroTelefono = nroTelefono;
	}


	public String informacionDeInicio() {
		if(SEM.getSEM().getSistemaDeCelulares().getSaldoAsociadoA(this.nroTelefono) > 0) {
			return "Inicio: " + horaInicio.toString() + " - Hora máxima de fin: " +
					this.horaMaximaFin();
		}
			else {
				return "Saldo insuficiente. Estacionamiento no permitido.";
		}	
	}
	
	
	public String informacionDeFin() {
		LocalTime fin = LocalTime.now();
		return "Inicio: " + horaInicio.toString() + " -Fin: " +
			   fin.toString() + " - Duración: " + (fin.getHour() - horaInicio.getHour()) + 
			   " - Costo: " + this.costoActual();
	}
	
	
}
