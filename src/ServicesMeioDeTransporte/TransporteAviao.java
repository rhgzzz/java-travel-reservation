package ServicesMeioDeTransporte;

import Entities.Reserva;

public class TransporteAviao implements MeioDeTransporte {

	Reserva reserva = new Reserva();
	private double taxaEmbarque = 440.0;
	
	@Override
	public double calcularValorFinal(Reserva reserva) {
		double valorViagem = taxaEmbarque + reserva.getPrecoBase();
		reserva.setPrecoCalculado(valorViagem);
		return valorViagem;
	}

	public double getTaxaEmbarque() {
		return taxaEmbarque;
	}
	
	
}