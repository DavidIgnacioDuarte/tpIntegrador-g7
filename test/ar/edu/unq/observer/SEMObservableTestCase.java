package ar.edu.unq.observer;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.estacionamiento.Estacionamiento;
import ar.edu.unq.sem.SEM;

public class SEMObservableTestCase {
	
	Observer observer1;
	Observer observer2;
	
	@Test
	public void agregarSuscriptor() {
		SEM.getSEM().suscribir(observer1);
		
		assertTrue(SEM.getSEM().getSuscriptores().contains(observer1));
	}
	
	@Test
	public void quitarSuscriptor() {
		SEM.getSEM().suscribir(observer1);
		SEM.getSEM().desuscribir(observer1);
		
		assertTrue(!SEM.getSEM().getSuscriptores().contains(observer1));
	}
	
	@Test public void notificarTest() {
		Estacionamiento estacionamiento = mock(Estacionamiento.class);
		observer1 = mock(Observer.class);
		observer2 = mock(Observer.class);
		
		SEM.getSEM().suscribir(observer1);
		SEM.getSEM().suscribir(observer2);
		
		SEM.getSEM().notificar(estacionamiento);
		
		verify(observer1, times(1)).update(estacionamiento);
		verify(observer2, times(1)).update(estacionamiento);
	}
}













