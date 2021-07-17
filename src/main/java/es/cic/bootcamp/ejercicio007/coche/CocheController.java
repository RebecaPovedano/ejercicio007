package es.cic.bootcamp.ejercicio007.coche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CocheController {

	@Autowired 
	private CocheService cocheService;
	
	
	
	@GetMapping("encender")
	public int encender() {
		return cocheService.encender();
	}
}
