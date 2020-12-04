package ar.edu.unq.app;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unq.zona.Zona;

class AppUsuarioTest {
	
	private AppUsuario app;
	private Zona zona;

	@BeforeEach
	void setUp() {
		
		SEM.clearSEM();
		
		app = new AppUsuario(1122334455L, "ABC-123");
		app.activarAsistenciaAlUsuario();
	}
	
	@Test
	void getterTest() {
		assertEquals(app.getNroCelular(),1122334455L);
	}
	
	@Test
	void testInicioDeEstacionamiento() {
		app.iniciarEstacionamiento();
		assertTrue(app.hayEstacionamientoEnCurso());
	}
	
	@Test
	void testSaldoInicial() {
		assertEquals(app.consultarSaldo(), 0d);
	}
	
	@Test
	void testAsistenciaActiva() {
		assertTrue(app.estaActivaAsistenciaAlUsuario());
	}
	
	@Test
	void testDesactivadaLaAsistencia() {
		app.desactivarAsistenciaAlUsuario();
		assertFalse(app.estaActivaAsistenciaAlUsuario());
	}

	@Test
	void testZonas() {
		zona = mock(Zona.class);
		app.cambiarZona(zona);
		assertEquals(app.getZonaActualParado(), zona);
		assertTrue(app.estaEnZonaValida());
		app.salirDeZona();
		assertFalse(app.estaEnZonaValida());
	}
}
