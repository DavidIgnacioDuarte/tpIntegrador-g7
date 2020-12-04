package ar.edu.unq.estacionamiento;

import java.time.LocalTime;

import ar.edu.unq.sem.SEM;

public class EstacionamientoApp extends Estacionamiento {

	private Long nroTelefono;
	
	
	public EstacionamientoApp(String patente) {
		super(patente);
		this.setNroTelefono(SEM.getSEM().getSistemaDeAsociaciones().getCelularAsociadoA(patente));
	}
	
	@Override
	public LocalTime horaMaximaFin() {
		Double saldo = SEM.getSEM().getSistemaDeAsociaciones().getSaldoAsociadoA(this.nroTelefono);
		Long saldoPorSegundos = (long)(saldo * 3600 / SEM.getSEM().getPrecioPorHora());
		LocalTime horaMax = this.getHoraInicio().plusSeconds(saldoPorSegundos);
		return horaMax;
	}
	
	public Double costoActual() {
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
		if(SEM.getSEM().getSistemaDeAsociaciones().getSaldoAsociadoA(this.nroTelefono) > 0) {
			return "Inicio: " + horaInicio.toString() + " - Hora máxima de fin: " +
					this.horaMaximaFin();
		}
			else {
				return "Saldo insuficiente. Estacionamiento no permitido.";
		}	
	}
	
	
	public String informacionDeFin() {
		LocalTime fin = LocalTime.now();
		return "Inicio: " + horaInicio.toString() + " -Fin: " + fin.toString() + " - Duración: " + 
				(fin.getHour() - horaInicio.getHour()) +  " - Costo: " + this.costoActual();
	}
	
	
}
