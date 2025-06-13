package ServicesMeioDeTransporte;

import Entities.Reserva;

public class TransporteCarro implements MeioDeTransporte {

	Reserva reserva = new Reserva();
	private double tarifaMotorista = 50.0;
	
	@Override
	public double calcularValorFinal(Reserva reserva) {
		double valorViagem = tarifaMotorista + reserva.getPrecoBase();
		reserva.setPrecoCalculado(valorViagem);
		return valorViagem;
	}

	public double getTarifaMotorista() {
		return tarifaMotorista;
	}

	
	
	
}
