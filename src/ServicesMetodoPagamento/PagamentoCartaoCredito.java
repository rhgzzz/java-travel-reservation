package ServicesMetodoPagamento;

public class PagamentoCartaoCredito implements MetodoPagamento {

	@Override
	public double pagar(double valor) {
		int taxa = 10;
		double valorFinal = valor + (valor * taxa / 1000); 
		System.out.printf("Valor da compra (taxa de %d%%): R$%.2f %n", taxa, valorFinal);
		System.out.println("Compra realizada via Cartão de Crédito - Recibo enviado!");
		return valorFinal;
	}

}
