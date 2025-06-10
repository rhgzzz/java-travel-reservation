package Services;

import Entities.Reserva;

public class TransporteCarro implements MeioDeTransporte {

	Reserva reserva = new Reserva();
	
	@Override
	public double calcularValorFinal(double precoBase) {
		double tarifaMotorista = 50.0;
		double valorViagem = tarifaMotorista + precoBase;
		System.out.printf("Valor da viagem (R$%.2f Tarifa do motorista): R$%.2f%n", tarifaMotorista, valorViagem);
		reserva.setPrecoCalculado(valorViagem);
		return valorViagem;
	}

}
