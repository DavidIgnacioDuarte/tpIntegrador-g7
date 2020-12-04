package ar.edu.unq.compras;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.zona.PuntoDeVenta;

public class RecargaCelularTest {

	RecargaCelular recarga;
	Integer numeroControl;
	Long numeroCelularAsociado;
	PuntoDeVenta puntoDeVenta;
	Double montoRecargado;
	
	
	@Before
	public void setUp() {
		
		numeroControl = 2;
		numeroCelularAsociado = 12983912l;
		puntoDeVenta = mock(PuntoDeVenta.class);
		montoRecargado = 200d;
		
		recarga = new RecargaCelular(numeroControl, puntoDeVenta, montoRecargado, numeroCelularAsociado);
	}
	
	
	@Test
	public void constructorTest() {
		
		assertEquals(numeroControl, recarga.getNumeroDeControl());
		assertEquals(puntoDeVenta, recarga.getPuntoDeVenta());
		assertEquals(LocalTime.now().getHour(), recarga.getHoraEfectuada().getHour());
		assertEquals(LocalTime.now().getMinute(), recarga.getHoraEfectuada().getMinute());
		assertEquals(LocalDate.now(), recarga.getFechaEfectuada());
		assertEquals(montoRecargado, recarga.getMontoARecargar());
		assertEquals(numeroCelularAsociado, recarga.getNumeroDeCelularAsociado());
		
	}
	
}






