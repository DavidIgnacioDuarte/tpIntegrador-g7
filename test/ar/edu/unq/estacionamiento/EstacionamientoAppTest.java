package ar.edu.unq.estacionamiento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import ar.edu.unq.compras.RecargaCelular;
import ar.edu.unq.sem.SEM;
import ar.edu.unq.sem.SistemaDeAsociaciones;
import ar.edu.unq.zona.PuntoDeVenta;
import ar.edu.unq.zona.Zona;


public class EstacionamientoAppTest { 

	private EstacionamientoApp estacionamientoApp;
	private SistemaDeAsociaciones sistAsoc;
	private PuntoDeVenta puntoDeVenta;
	private Long nroCelularUser;
	private Double saldo;
	
	
	@Before
	public void setUp() {
		
		SEM.clearSEM();
		
		sistAsoc = new SistemaDeAsociaciones();
		SEM.getSEM().setSistemaDeAsociaciones(sistAsoc);
		puntoDeVenta = new PuntoDeVenta(mock(Zona.class));
		nroCelularUser = 11509823l;
		sistAsoc.agregarAlSistemaDePatentes(nroCelularUser, "BCD-234");
		saldo = 50d;
		
		puntoDeVenta.recargarCelular(nroCelularUser, saldo);
		
		estacionamientoApp = new EstacionamientoApp("BCD-234");
		
	}
	
	
	@Test
	public void constructorTest() {
		
		assertEquals(this.nroCelularUser, estacionamientoApp.getNroTelefono());
		assertEquals("BCD-234", estacionamientoApp.getPatente());
		assertEquals(LocalTime.now().getHour(), estacionamientoApp.getHoraInicio().getHour());
		assertEquals(LocalTime.now().getMinute(), estacionamientoApp.getHoraInicio().getMinute());
		
		assertEquals(saldo, sistAsoc.consultarSaldo(nroCelularUser));
		
		//assertTrue(sistAsoc.consultarSaldo(this.nroCelularUser).equals(50d));
		
	}
	
	
	@Test
	public void calculoHoraMaximaTest() {
		
		SEM.getSEM().setPrecioPorHora(50d);
		
		assertEquals(estacionamientoApp.getHoraInicio().plusHours(1).getHour(), estacionamientoApp.horaMaximaFin().getHour());
		
		//LocalTime horaActual = mock(LocalTime.class);
		
		//when(LocalTime.now()).thenReturn(estacionamientoApp.getHoraInicio().plusHours(1));
		
		//assertTrue(estacionamientoApp.costoActual().equals(50d));
		
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
