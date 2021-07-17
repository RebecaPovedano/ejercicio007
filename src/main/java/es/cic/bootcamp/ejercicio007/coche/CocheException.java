package es.cic.bootcamp.ejercicio007.coche;

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
