package ar.edu.unq.estacionamiento;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import ar.edu.unq.compras.RecargaCelular;
import ar.edu.unq.sem.SEM;
import ar.edu.unq.sem.SistemaDeAsociaciones;
import ar.edu.unq.zona.PuntoDeVenta;


public class EstacionamientoAppTest {

	private EstacionamientoApp estacionamientoApp;
	private SistemaDeAsociaciones sistAsoc;
	private PuntoDeVenta puntoDeVenta;
	private Long nroCelularUser;
	
	
	@Before
	public void setUp() {
		
		sistAsoc = new SistemaDeAsociaciones();
		SEM.getSEM().setSistemaDeAsociaciones(sistAsoc);
		puntoDeVenta = mock(PuntoDeVenta.class);
		nroCelularUser = 11509823l;
		sistAsoc.agregarAlSistemaDePatentes(nroCelularUser, "BCD-234");
		
		puntoDeVenta.recargarCelular(nroCelularUser, 50d);
		
		estacionamientoApp = new EstacionamientoApp("BCD-234");
		
	}
	
	
	@Test
	public void constructorTest() {
		
		assertEquals(this.nroCelularUser, estacionamientoApp.getNroTelefono());
		assertEquals("BCD-234", estacionamientoApp.getPatente());
		assertEquals(LocalTime.now().getHour(), estacionamientoApp.getHoraInicio().getHour());
		assertEquals(LocalTime.now().getMinute(), estacionamientoApp.getHoraInicio().getMinute());
		
	}
	
	
	@Test
	public void calculosTest() {
		
		SEM.getSEM().setPrecioPorHora(50d);
		
		//System.out.println(estacionamientoApp.horaMaximaFin());
		
		//assertEquals(estacionamientoApp.getHoraInicio().plusHours(1).getHour(), estacionamientoApp.horaMaximaFin().getHour());
		
		//LocalTime horaActual = mock(LocalTime.class);
		
		when(LocalTime.now()).thenReturn(estacionamientoApp.getHoraInicio().plusHours(1));
		
		assertEquals(50d, estacionamientoApp.costoActual());
		
	}
	
	
	@Test
	public void informacionesInicioFin() {
		
		assertEquals(estacionamientoApp.informacionDeInicio(), "Inicio: " + estacionamientoApp.getHoraInicio().toString() + " - Hora máxima de fin: " +
				estacionamientoApp.horaMaximaFin());	
		
		assertEquals(estacionamientoApp.informacionDeFin(), "Inicio: " + estacionamientoApp.getHoraInicio().toString() + " - Fin: " +
				LocalTime.now() + " - Duración: " + (LocalTime.now().getHour() - estacionamientoApp.getHoraInicio().getHour()) + 
				   " - Costo: " + estacionamientoApp.costoActual());
		
	}
	
	
	
}
