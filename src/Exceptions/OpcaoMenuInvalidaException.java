package Exceptions;

public class OpcaoMenuInvalidaException extends RuntimeException {
	
	public OpcaoMenuInvalidaException(String mensagem) {
		super(mensagem);
	}
}
