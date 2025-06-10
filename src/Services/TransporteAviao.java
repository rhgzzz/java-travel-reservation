package Services;

public class TransporteAviao implements MeioDeTransporte {

	@Override
	public double calcularValorFinal(double precoBase) {
		double taxaEmbarque = 440.0;
		double valorViagem = taxaEmbarque + precoBase;
		System.out.printf("Valor da viagem (R$%.2f Taxa de embarque): R$%.2f%n", taxaEmbarque, valorViagem);
		return valorViagem;
	}
}