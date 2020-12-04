package ar.edu.unq.sem;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.compras.CompraPuntual;
import ar.edu.unq.estacionamiento.Estacionamiento;
import ar.edu.unq.estacionamiento.EstacionamientoApp;
import ar.edu.unq.estacionamiento.EstacionamientoCompraPuntual;
import ar.edu.unq.inspector.AppInspector;
import ar.edu.unq.inspector.Infraccion;
import ar.edu.unq.sensorDeHorario.SensorDeHorario;
import ar.edu.unq.zona.Zona;

public class SEMTestCase {
	private SistemaDeAsociaciones sistemaAsoc;
	
	@BeforeEach
	public void setUp() {
		
		SEM.clearSEM();
		
		sistemaAsoc = new SistemaDeAsociaciones();
		SEM.getSEM().setSistemaDeAsociaciones(sistemaAsoc);
	}
	
	@Test
	public void sistemaDeAsocTest() {
		SistemaDeAsociaciones sistemaAsoc = new SistemaDeAsociaciones(); //mock(SistemaDeAsociaciones.class);
		SEM.getSEM().setSistemaDeAsociaciones(sistemaAsoc);
		
		assertEquals(sistemaAsoc, SEM.getSEM().getSistemaDeAsociaciones());
	}
	
	
	@Test
	public void agregadoDeEstacionamientoTest() {
		Estacionamiento estacionamiento = mock(Estacionamiento.class);
		
		SEM.getSEM().agregarEstacionamiento(estacionamiento);
		
		assertTrue(SEM.getSEM().getEstacionamientos().contains(estacionamiento));
	}
	
	
	@Test
	public void finalizarEstacionamientoTest() {
		SistemaDeAsociaciones sistAsoc = new SistemaDeAsociaciones();
		Long nroRandom = 1234567890l;
		String patenteRandom = "DKA-926";
		
		sistAsoc.agregarAlSistemaDePatentes(nroRandom, patenteRandom);
	
		SEM.getSEM().setSistemaDeAsociaciones(sistAsoc);
		
		SEM.getSEM().agregarEstacionamiento(new EstacionamientoApp(patenteRandom));
		
		assertTrue(SEM.getSEM().esVigente(patenteRandom));
		
		SEM.getSEM().finalizarEstacionamiento(nroRandom);
		
		assertFalse(SEM.getSEM().esVigente(patenteRandom));
		
	}
	
	@Test
	public void estacionamientoConPatenteTest() {
		Estacionamiento estacionamiento = new EstacionamientoApp("ABC-123");
		
		SEM.getSEM().agregarEstacionamiento(estacionamiento);
		//TODO
		assertEquals(estacionamiento, SEM.getSEM().estacionamientoConPatente("ABC-123"));
	}
	
	@Test
	public void agregarZonaTest() {
		AppInspector appInspector = mock(AppInspector.class);
		Zona zona = new Zona(appInspector);
		
		SEM.getSEM().agregarZona(zona);
		
		assertTrue(SEM.getSEM().getZonas().contains(zona));
	}
	
	@Test
	public void agregarInfraccionTest() {
		Infraccion infraccion = mock(Infraccion.class);
		
		SEM.getSEM().agregarInfraccion(infraccion);
		
		assertTrue(SEM.getSEM().getInfracciones().contains(infraccion));
	}
	
	@Test
	public void numeroDeControlTest() {
		assertEquals(0, SEM.getSEM().getNumeroDeControl());
	}
	
	@Test
	public void getPrecioPorHoraTest() {
		SEM.getSEM().setPrecioPorHora(30d);
		
		assertEquals(30d, SEM.getSEM().getPrecioPorHora());
	}
	
	@Test
	public void seAgregaCompraYAvanzaNumeroControl() {
		CompraPuntual compra = mock(CompraPuntual.class);
		
		SEM.getSEM().agregarCompra(compra);
		
		assertEquals(1, SEM.getSEM().getNumeroDeControl());
	}
	
	@Test
	public void horaDeFinTest() {
		
		SEM.getSEM().setHoraDeFin(LocalTime.of(20,30));
		assertEquals(LocalTime.of(20,30), SEM.getSEM().getHoraDeFin());
		
	}
	
	@Test
	public void seDeterminaVigenciaYFinalizanEstacionamientos() {
		
		Estacionamiento est1 = mock(EstacionamientoCompraPuntual.class);
		Estacionamiento est2 = mock(EstacionamientoApp.class);
		Estacionamiento est3 = mock(EstacionamientoApp.class);
		
		when(est1.esVigente()).thenReturn(true);
		when(est2.esVigente()).thenReturn(false);
		when(est3.esVigente()).thenReturn(true);
		
		SEM.getSEM().agregarEstacionamiento(est1);
		SEM.getSEM().agregarEstacionamiento(est2);
		SEM.getSEM().agregarEstacionamiento(est3);
		
		SEM.getSEM().determinarVigencia();
		
		assertTrue(SEM.getSEM().getEstacionamientos().contains(est1));
		assertFalse(SEM.getSEM().getEstacionamientos().contains(est2));
		assertTrue(SEM.getSEM().getEstacionamientos().contains(est3));
		
		SEM.getSEM().finalizarEstacionamientosVigentes();
		
		assertTrue(SEM.getSEM().getEstacionamientos().isEmpty());
		
	}
	
}


















