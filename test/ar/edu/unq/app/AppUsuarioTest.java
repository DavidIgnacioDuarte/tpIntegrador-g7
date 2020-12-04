package ar.edu.unq.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.sem.SEM;

class AppUsuarioTest {
	
	private AppUsuario app;

	@BeforeEach
	void setUp() {
		app = new AppUsuario(1122334455L, "ABC-123");
	}
	
	@Test
	void getterTest() {
		assertEquals(app.getNroCelular(),1122334455L);
	}
	
	@Test
	void testInicioDeEstacionamiento() {
		app.iniciarEstacionamiento();
		assertTrue(SEM.getSEM().esVigente("ABC-123"));
	}
	
	@Test
	void testFinDeEstacionamiento() {
		app.finalizarEstacionamiento();
		assertFalse(SEM.getSEM().esVigente("ABC-123"));
	}

}
