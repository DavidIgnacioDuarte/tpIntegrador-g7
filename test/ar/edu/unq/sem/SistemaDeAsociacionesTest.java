package ar.edu.unq.sem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaDeAsociacionesTest {
	private Long nroRandom1;
	private Double saldo1;
	private SistemaDeAsociaciones sistAsoc = new SistemaDeAsociaciones();
	
	@BeforeEach
	public void setUp() {
		
		SEM.clearSEM();
		
		nroRandom1 = 1234567890l;
		saldo1 = 200d;
	}
	
	@Test
	public void consultarSaldoTest() {
		sistAsoc.agregarAlSistemaDeSaldos(nroRandom1, saldo1);
		
		assertEquals(200d, sistAsoc.getSaldoAsociadoA(nroRandom1));
	}
	
	@Test
	public void descontarSaldoTest() {
		sistAsoc.agregarAlSistemaDeSaldos(nroRandom1, saldo1);
		sistAsoc.descontarSaldo(nroRandom1, 20d);
		
		assertEquals(180d, sistAsoc.getSaldoAsociadoA(nroRandom1));
	}
}
