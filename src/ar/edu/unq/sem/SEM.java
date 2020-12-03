package ar.edu.unq.sem;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ar.edu.unq.compras.Compra;
import ar.edu.unq.estacionamiento.Estacionamiento;
import ar.edu.unq.inspector.Infraccion;
import ar.edu.unq.zona.Zona;

public class SEM extends Observable {
	private static SEM sem;
	private SistemaDeSaldos sistemaSaldos = new SistemaDeSaldos();
	
//	private Map<Long, Double> nombreMap = new HashMap<Long, Double>();
	private List<Estacionamiento> estacionamientos = new ArrayList<Estacionamiento>();
	private List<Zona> zonas = new ArrayList<Zona>();
	private List<Infraccion> infracciones = new ArrayList<Infraccion>();
	private List<Compra> compras = new ArrayList<Compra>();
		
	//TODO mover esto a otra clase para no violar el principio de responsabilidad única.
	private SEM() {}
	
	public SistemaDeSaldos getSistemaDeSaldos() {
		return sistemaSaldos;
	}
	
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
	
	public void agregarZona(Zona zona) {
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












