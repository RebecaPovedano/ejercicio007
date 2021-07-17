package es.cic.bootcamp.ejercicio007.coche;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CocheController {

	@GetMapping("encender")
	public int encender() {
		throw new UnsupportedOperationException("Operación no implementada todavía");
	}
}
