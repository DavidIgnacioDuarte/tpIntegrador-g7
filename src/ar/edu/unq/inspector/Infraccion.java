package ar.edu.unq.inspector;

import java.time.LocalDate;
import java.time.LocalTime;

import ar.edu.unq.zona.Zona;

public class Infraccion {

	String patente;
	LocalTime horaEfectuada;
	LocalDate fechaEfectuada;
	Zona zonaEnDondeSeEfectuo;
	String nombreDeInspectorQueEfectuo;
	
	
	public Infraccion(String patente, Zona zonaEnDondeSeEfectuo, String nombreDeInspectorQueEfectuo) {
		super();
		this.setPatente(patente);
		this.setHoraEfectuada(LocalTime.now());
		this.setFechaEfectuada(LocalDate.now());
		this.setZonaEnDondeSeEfectuo(zonaEnDondeSeEfectuo);
		this.setNombreDeInspectorQueEfectuo(nombreDeInspectorQueEfectuo);
	}
	
	
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
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
	
	public Zona getZonaEnDondeSeEfectuo() {
		return zonaEnDondeSeEfectuo;
	}
	public void setZonaEnDondeSeEfectuo(Zona zonaEnDondeSeEfectuo) {
		this.zonaEnDondeSeEfectuo = zonaEnDondeSeEfectuo;
	}
	
	public String getNombreDeInspectorQueEfectuo() {
		return nombreDeInspectorQueEfectuo;
	}
	public void setNombreDeInspectorQueEfectuo(String nombreDeInspectorQueEfectuo) {
		this.nombreDeInspectorQueEfectuo = nombreDeInspectorQueEfectuo;
	}

}
