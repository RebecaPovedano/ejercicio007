package es.cic.bootcamp.ejercicio007.motor;

public class MotorException extends RuntimeException {
	
    private int potencia;
    
	public MotorException() {
		super();
	}

	public MotorException(String message, int potencia, Throwable cause) {
		super(message, cause);
		this.potencia=potencia;
	}

	public MotorException(String message, int potencia) {
		super(message);
		this.potencia=potencia;
	}

	public int getPotencia() {
		return potencia;
	}

}
