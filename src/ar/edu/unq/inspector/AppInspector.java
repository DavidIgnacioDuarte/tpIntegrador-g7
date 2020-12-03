package ar.edu.unq.inspector;

import ar.edu.unq.sem.SEM;
import ar.edu.unq.zona.Zona;

public class AppInspector {

	private String nombre;
	private Zona zonaACargo;
	
	
	public AppInspector(String nombre, Zona zonaACargo) {
		super();
		this.setNombre(nombre);
		this.setZonaACargo(zonaACargo);
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Zona getZonaACargo() {
		return zonaACargo;
	}
	public void setZonaACargo(Zona zonaACargo) {
		this.zonaACargo = zonaACargo;
	}

	public void verificarVigencia(String patente) {
		if(!SEM.getSEM().esVigente(patente)) {
			this.elevarInfraccion(patente);
		}
	}
	
	public void elevarInfraccion(String patente) {
		SEM.getSEM().agregarInfraccion(new Infraccion(patente, zonaACargo, nombre));
	}
	
}
