package Services;

public class TransporteOnibus implements MeioDeTransporte {

	@Override
	public double calcularValorFinal(double precoBase) {
		int taxaDesconto = 30;
		double valorViagem = precoBase - (precoBase * taxaDesconto / 100);
		System.out.printf("Valor da viagem (%d%% de desconto): R$%.2f%n", taxaDesconto, valorViagem);
		return valorViagem;
	}

}
