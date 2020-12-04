package ar.edu.unq.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.sem.SEM;

class ModoAutomaticoTest {
	private ModoAutomatico modo;
	private AppUsuario app;
	
	@BeforeEach
	void setUp(){
		
		SEM.clearSEM();
		
		modo = new ModoAutomatico();
		app = new AppUsuario(1122334455l, "ABC-123");
		app.setModo(modo);
		
	}
	
	@Test
	void testCaminando() {
		app.walking();
		assertTrue(app.hayEstacionamientoEnCurso());
	}
	
	@Test
	void testConduciendo() {
		app.driving();
		assertFalse(app.hayEstacionamientoEnCurso());
	}

}
