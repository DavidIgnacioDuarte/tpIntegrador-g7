package ar.edu.unq.compras;

import ar.edu.unq.zona.PuntoDeVenta;
import ar.edu.unq.zona.Zona;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

public class CompraPuntualTest {

	CompraPuntual compraPuntual;
	PuntoDeVenta puntoDeVenta;
	Integer cantidadHorasAComprar;
	Integer numeroControl;
	
	@Before
	public void setUp() {
		cantidadHorasAComprar = 3;
		numeroControl = 1;
		puntoDeVenta = new PuntoDeVenta(mock(Zona.class));
		compraPuntual = new CompraPuntual(numeroControl, puntoDeVenta, cantidadHorasAComprar);
	}
	
	@Test
	public void constructorTest() {
		
		assertEquals(cantidadHorasAComprar, compraPuntual.getHorasCompradas());
		assertEquals(numeroControl, compraPuntual.getNumeroDeControl());
		assertEquals(puntoDeVenta, compraPuntual.getPuntoDeVenta());
		assertEquals(LocalTime.now().getHour(), compraPuntual.getHoraEfectuada().getHour());
		assertEquals(LocalTime.now().getMinute(), compraPuntual.getHoraEfectuada().getMinute());
		assertEquals(LocalDate.now(), compraPuntual.getFechaEfectuada());
		
	}
	
}
