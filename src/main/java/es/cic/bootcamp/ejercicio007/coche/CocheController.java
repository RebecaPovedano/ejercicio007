package es.cic.bootcamp.ejercicio007.coche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.bootcamp.ejercicio007.motor.MotorException;

@RestController
public class CocheController {

	@Autowired 
	private CocheService cocheService;	
	
	@GetMapping("encender")
	public int encender() {
		int potencia;
		try {
			potencia=cocheService.encender();
			return potencia;
		} catch (MotorException e) {
			throw new CocheException("El coche no arranca, los motores no tienen potencia suficiente",e);
		}
		
	}
}
