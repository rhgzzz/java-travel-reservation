package ServicesMetodoPagamento;

public class PagamentoPix implements MetodoPagamento {

	@Override
	public double pagar(double valor) {
		int taxaDesconto = 5;
		double valorFinal = valor - (valor * taxaDesconto / 100);
		System.out.printf("Valor da compra (%d%% de desconto): R$%.2f %n", taxaDesconto, valorFinal);
		System.out.println("Compra realizada via PIX - Recibo enviado!");
		return valorFinal;
	}

}
