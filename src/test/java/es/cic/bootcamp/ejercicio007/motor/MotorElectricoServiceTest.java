package es.cic.bootcamp.ejercicio007.motor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MotorElectricoServiceTest {

	private MotorElectricoService cut;
	
	@BeforeEach
	void setUp() throws Exception {
		cut=new MotorElectricoService();
	}

	@Test
	void testArrancarPotenciaMinima() {
		int potencia=cut.arrancar();
		assertTrue(potencia>=5, 
				String.format("La potencia es menor de 5. La potencia es %d",potencia));
	}

	@Test
	void testArrancarPotenciaMaxima() {
		int potencia=cut.arrancar();
		assertTrue(potencia<=40, 
				String.format("La potencia es mayor de 40. La potencia es %d",potencia));
	}
}
