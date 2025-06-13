package ServicesMeioDeTransporte;

import Entities.Reserva;

public class TransporteOnibus implements MeioDeTransporte {

	Reserva reserva = new Reserva();
	private int taxaDesconto = 30;
	
	@Override
	public double calcularValorFinal(Reserva reserva) {
		double valorViagem = reserva.getPrecoBase() - (reserva.getPrecoBase() * taxaDesconto / 100);
		reserva.setPrecoCalculado(valorViagem);
		return valorViagem;
	}

	public int getTaxaDesconto() {
		return taxaDesconto;
	}
	
	

}
