package ar.edu.unq.compras;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Compra {
	
	int numeroDeControl;
	LocalTime horaEfectuada;
	LocalDate fechaEfectuada;
	
	
	public int getNumeroDeControl() {
		return numeroDeControl;
	}
	
	public void setNumeroDeControl(int numeroDeControl) {
		this.numeroDeControl = numeroDeControl;
	}

	public LocalTime getHoraEfectuada() {
		return horaEfectuada;
	}


	public void setHoraEfectuada(LocalTime horaEfectuada) {
		this.horaEfectuada = horaEfectuada;
	}


	public LocalDate getFechaEfectuada() {
		return fechaEfectuada;
	}


	public void setFechaEfectuada(LocalDate fechaEfectuada) {
		this.fechaEfectuada = fechaEfectuada;
	}
	
}
