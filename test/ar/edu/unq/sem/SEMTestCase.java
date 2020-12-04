package ar.edu.unq.sem;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.estacionamiento.Estacionamiento;
import ar.edu.unq.estacionamiento.EstacionamientoApp;
import ar.edu.unq.inspector.AppInspector;
import ar.edu.unq.inspector.Infraccion;
import ar.edu.unq.zona.Zona;

public class SEMTestCase {
	private SistemaDeAsociaciones sistemaAsoc;
	
	@BeforeEach
	public void setUp() {
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
	public void singletonSEMTest() {
//		SEM sem = mock(SEM.class);
		
//		verify(sem, times(1)).getSEM();
		
		
//		sem.getSEM();
	}
	
	@Test
	public void agregadoDeEstacionamientoTest() {
		Estacionamiento estacionamiento = mock(Estacionamiento.class);
		
		SEM.getSEM().agregarEstacionamiento(estacionamiento);
		
		assertTrue(SEM.getSEM().getEstacionamientos().contains(estacionamiento));
	}
	
//	@Test
//	public void finalizarEstacionamientoTest() {
//		SistemaDeAsociaciones sistAsoc = new SistemaDeAsociaciones();
//		Long nroRandom = 1234567890l;
//		
//		
//		
//		SEM.getSEM().setSistemaDeAsociaciones(sistAsoc);
//		sistAsoc.
//		
//	}
	
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
	
	@Test void getPrecioPorHoraTest() {
		SEM.getSEM().setPrecioPorHora(30d);
		
		assertEquals(30d, SEM.getSEM().getPrecioPorHora());
	}
	
	@Test void esVigenteTest() {
		//TODO
	}
}


















