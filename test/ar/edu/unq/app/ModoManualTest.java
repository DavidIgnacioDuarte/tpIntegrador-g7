package ar.edu.unq.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModoManualTest {
	private ModoManual modo;
	private AppUsuario app;
	
	@BeforeEach
	void setUp(){
		modo = new ModoManual();
		app = new AppUsuario(1122334455l, "ABC-123");
		app.setModo(modo);
		
	}
	
	@Test
	void testCaminando() {
		app.walking();
		assertEquals("Caminando", app.getUltimaNotificacion());
	}
	
	@Test
	void testConduciendo() {
		app.driving();
		assertEquals("Conduciendo", app.getUltimaNotificacion());
	}

}
