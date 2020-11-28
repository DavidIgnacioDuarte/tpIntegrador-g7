package ar.edu.unq.sem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SEM extends Observable {
	private Map<Long, Double> nombreMap = new HashMap<Long, Double>();
	private List<Estacionamiento> estacionamientos = new ArrayList<Estacionamiento>();
	private List<ZonaDeEstacionamiento> zonas = new ArrayList<ZonaDeEstacionamiento>();
	private List<Infraccion> infracciones = new ArrayList<Infraccion>();
	private List<Compra> compras = new ArrayList<Compra>();
	
	public SEM() {
		
	}
	
	public void agregarEstacionamiento(Estacionamiento estacionamiento) {
		estacionamientos.add(estacionamiento);
		this.notificar(estacionamiento);
	}
	
	public void terminarEstacionamiento(Estacionamiento estacionamiento) {
		estacionamientos.remove(estacionamiento);
		this.notificar(estacionamiento);
	}
	
	public void agregarZona(ZonaDeEstacionamiento zona) {
		zonas.add(zona);
	}
	
	public void agregarInfraccion(Infraccion infraccion) {
		infracciones.add(infraccion);
	}
}












