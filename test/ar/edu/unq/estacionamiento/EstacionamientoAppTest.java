package ar.edu.unq.estacionamiento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;
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
		
		SEM.getSEM().setPrecioPorHora(50d);
		
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
		
	}
	
	
	@Test
	public void calculoHoraMaximaTest() {
		
		SEM.getSEM().setPrecioPorHora(50d);
		
		assertEquals(estacionamientoApp.getHoraInicio().plusHours(1).getHour(), estacionamientoApp.horaMaximaFin().getHour());
		
	}
	
	
	@Test
	public void calculoCostoTest() {
		
		EstacionamientoApp mockEstacionamiento = mock(EstacionamientoApp.class);
		
		when(mockEstacionamiento.getHoraInicio()).thenReturn(LocalTime.of(9, 30));
		when(mockEstacionamiento.horaMaximaFin()).thenReturn(LocalTime.of(10, 30));
		
		assertFalse(mockEstacionamiento.costoActual().equals(50d));
		
	}
	
	
	@Test
	public void informacionInicioConSaldoYSinSaldo() {
		
		assertEquals(estacionamientoApp.informacionDeInicio(), "Inicio: " + estacionamientoApp.getHoraInicio().toString() + " - Hora máxima de fin: " +
				estacionamientoApp.horaMaximaFin());	
		
		sistAsoc.descontarSaldo(nroCelularUser, 50d);
		
		assertEquals(estacionamientoApp.informacionDeInicio(), "Saldo insuficiente. Estacionamiento no permitido.");
		
	}
	
	
	
}
