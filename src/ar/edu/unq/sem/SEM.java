package ar.edu.unq.sem;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import ar.edu.unq.compras.Compra;
import ar.edu.unq.estacionamiento.Estacionamiento;
import ar.edu.unq.inspector.Infraccion;
import ar.edu.unq.observer.Observable;
import ar.edu.unq.sensorDeVigencia.SensorDeVigencia;
import ar.edu.unq.zona.Zona;

public class SEM extends Observable implements SensorDeVigencia {
	private Integer numeroDeControl = 0;
	private static SEM sem;
	private SistemaDeSaldos sistemaSaldos = new SistemaDeSaldos();
	
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
	
	public void finalizarEstacionamiento(Long nroCelular) {
		Estacionamiento estacionamiento = this.estacionamientoConNum(nroCelular);
		
		estacionamientos.remove(estacionamiento);
		this.notificar(estacionamiento);
	}
	
	private Estacionamiento estacionamientoConNum(Long nroTelefono) {
		return estacionamientos.stream()
				.filter(e -> e.getNroTelefono().equals(nroTelefono))
				.findFirst()
				.get();
	}
	
	public void agregarZona(Zona zona) {
		zonas.add(zona);
	}
	
	public void agregarInfraccion(Infraccion infraccion) {
		infracciones.add(infraccion);
	}
	
	public void agregarCompra(Compra compra) {
		compras.add(compra);
		numeroDeControl++;
	}
	
	@Override
	public void determinarVigencia() {
		estacionamientos = estacionamientos.stream()
			.filter(e -> e.esVigente())
			.collect(Collectors.toList());
	}
	
	public Integer getNumeroDeControl() {		
		return numeroDeControl;
	}
}












