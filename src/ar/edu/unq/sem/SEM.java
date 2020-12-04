package ar.edu.unq.sem;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.compras.Compra;
import ar.edu.unq.estacionamiento.Estacionamiento;
import ar.edu.unq.inspector.Infraccion;
import ar.edu.unq.observer.Observable;
import ar.edu.unq.sensorDeHorario.SensorDeHorario;
import ar.edu.unq.sensorDeVigencia.SensorDeVigencia;
import ar.edu.unq.zona.Zona;

public class SEM extends Observable implements SensorDeVigencia, SensorDeHorario {
	
	private Integer numeroDeControl = 0;
	private static SEM sem;
	private SistemaDeAsociaciones sistemaAsociaciones = new SistemaDeAsociaciones();
	private Double precioPorHora;
	
	private List<Estacionamiento> estacionamientos = new ArrayList<Estacionamiento>();
	private List<Zona> zonas = new ArrayList<Zona>();
	private List<Infraccion> infracciones = new ArrayList<Infraccion>();
	private List<Compra> compras = new ArrayList<Compra>();
	
	private LocalTime horaDeFin;
	
	
	public void finalizarEstacionamientosVigentes() {
		estacionamientos.forEach(e -> this.notificar(e));
		estacionamientos.clear();
	}
	
	public LocalTime getHoraDeFin() {
		return horaDeFin;
	}
	public void setHoraDeFin(LocalTime horaDeFin) {
		this.horaDeFin = horaDeFin;
	}

	private SEM() {}
	
	public SistemaDeAsociaciones getSistemaDeAsociaciones() {
		return sistemaAsociaciones;
	}
	
	public static SEM getSEM() {
		if(sem == null) {
			sem = new SEM();
		}
		
		return sem;
	}
	
	public static void clearSEM() {
		sem = null;
	}
	
	public void agregarEstacionamiento(Estacionamiento estacionamiento) {
		estacionamientos.add(estacionamiento);
		this.notificar(estacionamiento);
	}
	
	public void finalizarEstacionamiento(Long nroCelular) {
		String patenteAsociada = this.getSistemaDeAsociaciones().getPatenteAsociadaA(nroCelular);
		Estacionamiento estacionamiento = this.estacionamientoConPatente(patenteAsociada);
		
		estacionamientos.remove(estacionamiento);
		this.notificar(estacionamiento);
	}
	
	public Estacionamiento estacionamientoConPatente(String patente) {
		return estacionamientos.stream()
				.filter(e -> e.getPatente().equals(patente))
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

	public void setPrecioPorHora(Double precioPorHora) {
		this.precioPorHora = precioPorHora;
	}
	
	public Double getPrecioPorHora() {
		return precioPorHora;
	}

	public Boolean esVigente(String patente) {
		return estacionamientos.stream().anyMatch(e -> e.getPatente().equals(patente));
	}
	
	public void setSistemaDeAsociaciones(SistemaDeAsociaciones sistemaAsoc) {
		sistemaAsociaciones = sistemaAsoc;
	}
	
	public List<Estacionamiento> getEstacionamientos() {
		return estacionamientos;
	}
	
	public List<Zona> getZonas() {
		return zonas;
	}
	
	public List<Infraccion> getInfracciones() {
		return infracciones;
	}
}












