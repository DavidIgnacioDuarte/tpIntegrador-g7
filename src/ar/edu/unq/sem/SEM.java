package ar.edu.unq.sem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ar.edu.unq.estacionamiento.Estacionamiento;
import ar.edu.unq.inspector.Infraccion;

public class SEM extends Observable {
	private static SEM sem;
	
	private Map<Long, Double> nombreMap = new HashMap<Long, Double>();
	private List<Estacionamiento> estacionamientos = new ArrayList<Estacionamiento>();
	private List<ZonaDeEstacionamiento> zonas = new ArrayList<ZonaDeEstacionamiento>();
	private List<Infraccion> infracciones = new ArrayList<Infraccion>();
	private List<Compra> compras = new ArrayList<Compra>();
		
	//TODO mover esto a otra clase para no violar el principio de responsabilidad única.
	private SEM() {}
	
	public static SEM getSEM() {
		if(sem == null) {
			sem = new SEM();
		}
		
		return sem;
	}
	
	public void agregarEstacionamiento(Estacionamiento estacionamiento) {
		estacionamientos.add(estacionamiento);
		this.notificar(estacionamiento);
	}
	
	public void terminarEstacionamiento(Long nroTelefono, LocalTime hora) {
//		TODO: mejorar esta lógica
		Estacionamiento estacionamiento = this.estacionamientoConNum(nroTelefono);
		
		estacionamiento.terminarEstacionamiento(hora);
		this.notificar(estacionamiento);
	}
	
	public void agregarZona(ZonaDeEstacionamiento zona) {
		zonas.add(zona);
	}
	
	public void agregarInfraccion(Infraccion infraccion) {
		infracciones.add(infraccion);
	}
	
	private Estacionamiento estacionamientoConNum(Long nroTelefono) {
		return estacionamientos.stream()
			.filter(e -> e.getNroTelefono() == nroTelefono && e.getEsVigente())
			.findFirst()
			.get();																// Revisar esto
	}
}












