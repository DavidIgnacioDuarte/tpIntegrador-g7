package ar.edu.unq.sem;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.estacionamiento.Estacionamiento;

public class SEMTestCase {
	private SistemaDeAsociaciones sistemaAsoc;
	
	@BeforeEach
	public void setUp() {
//		SEM sem = SEM.getSEM();
//		SistemaDeAsociaciones sistemaAsoc = new SistemaDeAsociaciones(); //mock(SistemaDeAsociaciones.class);
//		SEM.getSEM().setSistemaDeAsociaciones(sistemaAsoc);
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
	
	
}


















