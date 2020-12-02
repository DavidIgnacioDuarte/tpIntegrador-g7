package ar.edu.unq.estacionamiento;

import java.time.LocalTime;

import ar.edu.unq.sem.SEM;

public class EstacionamientoApp extends Estacionamiento {

	private Long nroTelefono;
	
	
	public Long getNroTelefono() {
		return nroTelefono;
	}


	public void setNroTelefono(Long nroTelefono) {
		this.nroTelefono = nroTelefono;
	}


	public String informacionDeInicio() {
		if(SEM.getSEM().getSaldo(this.nroTelefono) > 0) {
			return "Inicio: " + horaInicio.toString() + " - Hora máxima de fin: " +
					this.getHoraMaxFin();
		}
			else {
				return "Saldo insuficiente. Estacionamiento no permitido.";
		}	
	}
	
	
	public String informacionDeFin() {
		LocalTime fin = LocalTime.now();
		return "Inicio: " + horaInicio.toString() + " -Fin: " +
			   fin.toString() + " - Duración: " + (fin.getHour() - horaInicio.getHour()) + 
			   " - Costo: " + this.costo(horaInicio, fin);
	}
	
	
	private Float costo(LocalTime inicio, LocalTime fin) {
		Float precio = SEM.getSEM().getPrecioPorHora(); //TODO en SEM
		Float precioPorHoras    = (fin.getHour() - inicio.getHour()) * precio;
		Float precioPorMinutos  = (fin.getMinute() - inicio.getMinute() ) * (precio / 60);
		Float precioPorSegundos = (fin.getSecond() - inicio.getSecond()) * (precio / 3600);
		return precioPorHoras + precioPorMinutos + precioPorSegundos;
	}
	
	
	@Override
	public LocalTime getHoraMaxFin() {
		if(this.horaMaxFin == null) {
			Float costoHora = SEM.getSEM().getSaldo(this.nroTelefono) / SEM.getSEM().getPrecioPorHora();
			int horas    = costoHora.intValue(); //Redondea siempre para abajo.
			int minutos  = (int)((costoHora % 1) * 60);
			int segundos = (int)((((costoHora % 1) * 60) % 1) * 60);
			this.setHoraMaxFin(horaInicio.plusHours(horas).plusMinutes(minutos).plusSeconds(segundos));
		}
		return this.getHoraMaxFin();
	}
	
	@Override
	public void finalizarEstacionamiento() {
		if(this.getEsActivo()) {
			this.setHoraMaxFin(LocalTime.now());
			SEM.getSEM().sistemaDeSaldos().descontarSaldo(this.getNroTelefono(), this.costo(this.getHoraInicio(), LocalTime.now()));
			this.setEsActivo(false);
		}
	}
	
}
