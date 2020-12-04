package ar.edu.unq.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.sem.SEM;

class ModoAutomaticoTest {
	
	private ModoAutomatico modo;
	private AppUsuario app;
	private Long numeroCel;
	private String patente;
	
	@BeforeEach
	void setUp(){
		
		SEM.clearSEM();
		
		numeroCel = 11231245l;
		patente = "ABC-123";
		
		modo = new ModoAutomatico();
		app = new AppUsuario(numeroCel, patente);
		
		SEM.getSEM().getSistemaDeAsociaciones().agregarAlSistemaDePatentes(numeroCel, patente);
		SEM.getSEM().getSistemaDeAsociaciones().agregarAlSistemaDeSaldos(numeroCel, 100d);
		
		app.setModo(modo);
		
		app.walking();
		
	}
	
	@Test
	void testCaminando() {
		assertTrue(app.hayEstacionamientoEnCurso());
	}
	
	@Test
	void testConduciendo() {
		app.driving();
		assertFalse(app.hayEstacionamientoEnCurso());
	}

}
