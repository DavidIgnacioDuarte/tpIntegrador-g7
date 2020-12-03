package ar.edu.unq.inspector;

import ar.edu.unq.estacionamiento.Estacionamiento;
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

	public void recorrerZona() {
		//this.zonaACargo.getEstacionamientos().forEach({estacionamiento => this.verificarVigencia(estacionamiento)})
	}
	
	public void verificarVigencia(Estacionamiento estacionamiento) {
		if(!estacionamiento.esVigente()) {
			this.elevarInfraccion(estacionamiento.getPatente());
		}
	}
	
	public void elevarInfraccion(String patente) {
		SEM.getSEM().agregarInfraccion(new Infraccion(patente, zonaACargo, nombre));
	}
	
}
