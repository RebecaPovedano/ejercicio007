package es.cic.bootcamp.ejercicio007.motor;

import org.springframework.stereotype.Service;

@Service
public class MotorCombustionService {

	private int potencia;
	
	public MotorCombustionService() {
		double random=Math.random()*35+5;
		potencia=(int) Math.floor(random);
	}
	
	public int arrancar() {
		return potencia;
	}
}
