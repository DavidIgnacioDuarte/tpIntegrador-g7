package ar.edu.unq.inspector;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalTime;

import ar.edu.unq.estacionamiento.EstacionamientoApp;
import ar.edu.unq.estacionamiento.EstacionamientoCompraPuntual;
import ar.edu.unq.sem.SEM;
import ar.edu.unq.zona.Zona;

public class InspectorTest {

	AppInspector inspector;
	Zona zonaACargo;
	
	@Before
	public void setUp() {
		
		zonaACargo = mock(Zona.class);
		inspector = new AppInspector("Carlos", zonaACargo);

		
	}
	
	
	@Test
	public void constructorTest() {
		
		assertEquals("Carlos", inspector.getNombre());
		assertEquals(zonaACargo, inspector.getZonaACargo());
		
	}
	
	
	@Test
	public void verificarVigenciasYLevantarInfraccion() {
		
		EstacionamientoCompraPuntual estacionamientoP = mock(EstacionamientoCompraPuntual.class);
		EstacionamientoApp estacionamientoA = mock(EstacionamientoApp.class);
		
		when(estacionamientoP.getPatente()).thenReturn("ABC-123");
		when(estacionamientoA.getPatente()).thenReturn("DBT-487");
		
		SEM.getSEM().agregarEstacionamiento(estacionamientoP);
		
		inspector.verificarVigencia("ABC-123");
		
		assertTrue(SEM.getSEM().getEstacionamientos().contains(estacionamientoP));
		
		inspector.verificarVigencia("DBT-487");
		
		assertTrue(SEM.getSEM().getInfracciones().stream().anyMatch(i -> i.getPatente().equals("DBT-487")));
		
		Infraccion infraccionHecha = SEM.getSEM().getInfracciones().get(0);
		
		assertEquals(LocalDate.now(), infraccionHecha.getFechaEfectuada());
		
		assertEquals(LocalTime.now().getHour(), infraccionHecha.getHoraEfectuada().getHour());
		assertEquals(LocalTime.now().getMinute(), infraccionHecha.getHoraEfectuada().getMinute());
		
		assertEquals("Carlos", infraccionHecha.getNombreDeInspectorQueEfectuo());
		
		assertEquals(zonaACargo, infraccionHecha.getZonaEnDondeSeEfectuo());
		
	}
	
	
}
