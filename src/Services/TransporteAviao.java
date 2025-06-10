package Services;

import Entities.Reserva;

public class TransporteAviao implements MeioDeTransporte {

	Reserva reserva = new Reserva();
	
	@Override
	public double calcularValorFinal(double precoBase) {
		double taxaEmbarque = 440.0;
		double valorViagem = taxaEmbarque + precoBase;
		System.out.printf("Valor da viagem (R$%.2f Taxa de embarque): R$%.2f%n", taxaEmbarque, valorViagem);
		reserva.setPrecoCalculado(valorViagem);
		return valorViagem;
	}
}