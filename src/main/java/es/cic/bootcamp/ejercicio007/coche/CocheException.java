package es.cic.bootcamp.ejercicio007.coche;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CocheException extends RuntimeException {
	
	public CocheException() {
		super();
	}

	public CocheException(String message, Throwable cause) {
		super(message, cause);
	}

	public CocheException(String message) {
		super(message);
	}

}
