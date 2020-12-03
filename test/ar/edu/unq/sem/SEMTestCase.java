package ar.edu.unq.sem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SEMTestCase {
	private SistemaDeAsociaciones sa;
	
	@BeforeEach
	public void setUp() throws Exception {
		sa = mock(SistemaDeAsociaciones.class);
	}
	
	@Test
	public void testasdasd() {
		assertEquals(sa, sa);
	}
}
