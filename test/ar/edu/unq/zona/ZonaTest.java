package ar.edu.unq.zona;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.inspector.AppInspector;

class ZonaTest {
	private Zona zona; 
	private PuntoDeVenta pdv;
	private AppInspector inspector;
	
	@BeforeEach
	void setUp() {
		pdv = mock(PuntoDeVenta.class);
		inspector = mock(AppInspector.class);
		zona = new Zona(inspector);
	}

	@Test
	void testConstructor() {
		assertEquals(zona.getInspector(), inspector);
	}
	
	@Test
	void coleccionPDVTest() { 
		zona.addPDV(pdv);
		assertEquals(zona.cantidadPDV(), 1);
	}

}
