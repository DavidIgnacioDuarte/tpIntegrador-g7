package ar.edu.unq.estacionamiento;

import static org.junit.Assert.assertEquals;
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
		
		assertEquals(estacionamientoPuntual.getPatente(), "ABC-123");
		assertEquals(estacionamientoPuntual.getHoraInicio().getHour(), LocalTime.now().getHour());
		assertEquals(estacionamientoPuntual.getHoraInicio().getMinute(), LocalTime.now().getMinute());
		assertEquals(estacionamientoPuntual.getHabilitacionCompra(), this.compraHabilitacion);
		
	}
	
	
	
}
