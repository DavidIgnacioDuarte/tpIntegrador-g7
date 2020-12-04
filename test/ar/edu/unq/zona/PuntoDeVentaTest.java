package ar.edu.unq.zona;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.sem.SEM;

import static org.mockito.Mockito.*;

class PuntoDeVentaTest {
	private Zona zona;
	private PuntoDeVenta pdv;
	
	@BeforeEach
	void setUp() {
		zona = mock(Zona.class);
		pdv = new PuntoDeVenta(zona);
	}
	
	@Test
	void testConstructor() {
		assertEquals(pdv.getZonaPDV(), zona);
	}
	
	@Test
	void testRecargaDeSaldo() {
		pdv.recargarCelular(1122334455l, 50d);
		pdv.recargarCelular(1122334455l, 25d);
		assertEquals(SEM.getSEM().getSistemaDeAsociaciones().consultarSaldo(1122334455L), 75d);
	}
	
	@Test
	void testInicioDeEstacionamiento() {
		pdv.iniciarEstacionamiento("ABC-124", 3);
		assertTrue(SEM.getSEM().esVigente("ABC-124"));
	}

}
