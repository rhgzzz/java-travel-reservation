package Services;

import Entities.Reserva;

public class TransporteOnibus implements MeioDeTransporte {

	Reserva reserva = new Reserva();
	
	@Override
	public double calcularValorFinal(double precoBase) {
		int taxaDesconto = 30;
		double valorViagem = precoBase - (precoBase * taxaDesconto / 100);
		System.out.printf("Valor da viagem (%d%% de desconto): R$%.2f%n", taxaDesconto, valorViagem);
		reserva.setPrecoCalculado(valorViagem);
		return valorViagem;
	}

}
