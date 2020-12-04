package ar.edu.unq.estacionamiento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.compras.CompraPuntual;

public class EstacionamientoCompraPuntualTest {
	
	//private PuntoDeVenta puntoDeVenta;
	private CompraPuntual compraHabilitacion;
	private EstacionamientoCompraPuntual estacionamientoPuntual;
	
	@Before
	public void setUp() {
		
		compraHabilitacion = mock(CompraPuntual.class);
		when(compraHabilitacion.getHorasCompradas()).thenReturn(3);
		
		estacionamientoPuntual = new EstacionamientoCompraPuntual("ABC-123", compraHabilitacion);
		
	}
	
	
	@Test
	public void constructorTest() {
		
		assertEquals("ABC-123", estacionamientoPuntual.getPatente());
		assertEquals(LocalTime.now().getHour(), estacionamientoPuntual.getHoraInicio().getHour());
		assertEquals(LocalTime.now().getMinute(), estacionamientoPuntual.getHoraInicio().getMinute());
		assertEquals(this.compraHabilitacion, estacionamientoPuntual.getHabilitacionCompra());
		
		assertTrue(estacionamientoPuntual.esVigente());
		
	}
	
	
	@Test
	public void horaMaximaFinTest() {
		
		assertEquals(estacionamientoPuntual.getHoraInicio().plusHours(compraHabilitacion.getHorasCompradas()), estacionamientoPuntual.horaMaximaFin());
		
	}
	
}
