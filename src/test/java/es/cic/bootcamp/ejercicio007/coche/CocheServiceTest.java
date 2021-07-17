package es.cic.bootcamp.ejercicio007.coche;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.cic.bootcamp.ejercicio007.motor.MotorCombustionService;
import es.cic.bootcamp.ejercicio007.motor.MotorElectricoService;
import es.cic.bootcamp.ejercicio007.motor.MotorException;

class CocheServiceTest {

	private CocheService cut;
	private MotorElectricoService dependenciaElectrico;
	private MotorCombustionService dependenciaCombustion;
	
	@BeforeEach
	void setUp() throws Exception {
		cut=new CocheService();
		dependenciaElectrico=mock(MotorElectricoService.class);
		dependenciaCombustion=mock(MotorCombustionService.class);
		cut.setMotorElectrico(dependenciaElectrico);
		cut.setMotorCombustion(dependenciaCombustion);
	}

	@Test
	void testEncenderSoloElectrico() {
		when(dependenciaElectrico.arrancar()).thenReturn(22);
		int resultado=cut.encender();
		assertEquals(3, resultado,"El resultado no es 3");
		verify(dependenciaElectrico, times(1)).arrancar();
	}
	
	@Test
	void testEncenderElectricoYCombustion() {
		when(dependenciaElectrico.arrancar()).thenReturn(10);
		when(dependenciaCombustion.arrancar()).thenReturn(18);
		int resultado=cut.encender();
		assertEquals(4, resultado,"El resultado no es 4");
		verify(dependenciaElectrico, times(1)).arrancar();
		verify(dependenciaCombustion, times(1)).arrancar();
	}
	
	@Test
	void testEncenderPotenciaInsuficiente() {
		when(dependenciaElectrico.arrancar()).thenReturn(10);
		when(dependenciaCombustion.arrancar()).thenReturn(8);
		assertThrows(MotorException.class, () -> cut.encender());
		verify(dependenciaElectrico, times(1)).arrancar();
		verify(dependenciaCombustion, times(1)).arrancar();
	}

}
