package Exceptions;

public class OpcaoPagamentoInvalidaException extends RuntimeException {
	
	public OpcaoPagamentoInvalidaException (String mensagem) {
		super(mensagem);
	}
}
