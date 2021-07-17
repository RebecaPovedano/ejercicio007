package es.cic.bootcamp.ejercicio007.coche;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CocheControllerTest {

	private CocheController cut;
	private CocheService dependencia;
	
	@BeforeEach
	void setUp() throws Exception {
		cut=new CocheController();
		dependencia=mock(CocheService.class);
		cut.setCocheService(dependencia);
	}

	@Test
	void testEncenderSinErrores() throws CocheException {
		when(dependencia.encender()).thenReturn(5);
		int resultado=cut.encender();
		assertEquals(5,resultado,"El resultado no era el esperado");
		verify(dependencia,times(1)).encender();
	}
	
	@Test
	void testEncenderCocheException() {
		when(dependencia.encender()).thenThrow(CocheException.class);
		assertThrows(CocheException.class, ()-> cut.encender());
		verify(dependencia,times(1)).encender();
	}

}
