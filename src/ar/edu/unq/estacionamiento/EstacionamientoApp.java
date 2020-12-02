package ar.edu.unq.estacionamiento;

import java.time.LocalTime;

import ar.edu.unq.sem.SEM;

public class EstacionamientoApp extends Estacionamiento {

	long nroTelefono;
	
	
	@Override
	public Boolean esVigente() {
		return LocalTime.now().isBefore(this.horaMaxima());
	}
	
	
	public String informacionDeInicio() {
		if(nroTelefono.getCredito() > 0) {
			return "Inicio: " + horaInicio.toString() + " - Hora máxima de fin: " +
					this.horaMaxima();
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
	
	
	public LocalTime horaMaxima() {
		Float costoHora = nroTelefono.getCredito() / SEM.getSEM().getPrecioPorHora();
		int horas    = costoHora.intValue(); //Redondea siempre para abajo.
		int minutos  = (int)((costoHora % 1) * 60);
		int segundos = (int)((((costoHora % 1) * 60) % 1) * 60); 
		LocalTime horaMaxima = horaInicio.plusHours(horas).plusMinutes(minutos).plusSeconds(segundos);
		return horaMaxima;
	}
	
}
