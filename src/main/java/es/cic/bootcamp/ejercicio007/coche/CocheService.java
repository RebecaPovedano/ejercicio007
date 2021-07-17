package es.cic.bootcamp.ejercicio007.coche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.bootcamp.ejercicio007.motor.MotorCombustionService;
import es.cic.bootcamp.ejercicio007.motor.MotorElectricoService;
import es.cic.bootcamp.ejercicio007.motor.MotorException;

@Service
public class CocheService {

	@Autowired
	private MotorElectricoService motorElectrico;
	@Autowired
	private MotorCombustionService motorCombustion;
	
	private int potenciaTotal;
	
	public int encender () {
		int potenciaCombustion=0;
		int potenciaElectrico=motorElectrico.arrancar();
		if(potenciaElectrico<20) {
			potenciaCombustion=motorCombustion.arrancar();
		}
		potenciaTotal=potenciaElectrico+potenciaCombustion;
		if(potenciaTotal<20) {
			throw new MotorException("La potencia del motor es insuficiente",potenciaTotal);
		}
		return potenciaTotal/7;
	}
	
	/**
	 * Para realizar los tests unitarios de CocheService
	 * @param motorElectrico
	 */
	public void setMotorElectrico(MotorElectricoService motorElectrico) {
		this.motorElectrico = motorElectrico;
	}

	/**
	 * Para realizar los tests unitarios de CocheService
	 * @param motorCombustion
	 */
	public void setMotorCombustion(MotorCombustionService motorCombustion) {
		this.motorCombustion = motorCombustion;
	}
}
