package Entities;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ServicesMeioDeTransporte.TransporteAviao;
import ServicesMeioDeTransporte.TransporteCarro;
import ServicesMeioDeTransporte.TransporteOnibus;



public class CarrinhoDeReservas {
	
	private List<Reserva> carrinhoReservas = new ArrayList<Reserva>();
	
	Scanner sc = new Scanner (System.in);

	public void listarReservas() {
		
		for (int i = 0; i < carrinhoReservas.size(); i++) {
			System.out.printf("[%d] " + carrinhoReservas.get(i), i + 1 );
			carrinhoReservas.get(i).MostrarPrecoCalculado();
			
			MeioDeTransporte transporte = carrinhoReservas.get(i).getTransporte();
			
			if (transporte == MeioDeTransporte.AVIAO) {
				TransporteAviao aviao = new TransporteAviao();
				System.out.printf("Valor da viagem (R$%.2f Taxa de embarque): R$%.2f%n%n",aviao.getTaxaEmbarque() , carrinhoReservas.get(i).getPrecoCalculado());
			} 
			else if (transporte == MeioDeTransporte.CARRO) {
				TransporteCarro carro = new TransporteCarro();
				System.out.printf("Valor da viagem (R$%.2f Tarifa do motorista): R$%.2f%n%n", carro.getTarifaMotorista(), carrinhoReservas.get(i).getPrecoCalculado());
			} 
			else {
				TransporteOnibus onibus = new TransporteOnibus();
				System.out.printf("Valor da viagem (%d%% de desconto): R$%.2f%n%n", onibus.getTaxaDesconto(), carrinhoReservas.get(i).getPrecoCalculado());
			}
			
		}
		
	}
	
	public void adicionarReserva(Reserva reserva) {
		carrinhoReservas.add(reserva);		
	}
	
	public void removerReserva(int index) {
		
		int indexAjustado = index - 1;
			if (indexAjustado >= 0 && indexAjustado < carrinhoReservas.size()) {
				carrinhoReservas.remove(indexAjustado);
				System.out.println();
				System.out.printf("Reserva [%d] removida com sucesso!%n", index);
				System.out.print("Carrinho de reservas ATUALIZADO! \n");
			} 
	}
	
	public double calcularTotal() {
		double valorTotal = 0.0;
		for (Reserva reserva : carrinhoReservas) {
			valorTotal += reserva.getPrecoCalculado();
		}
		System.out.printf("O valor do seu carrinho de reservas é de: R$%.2f %n", valorTotal);
		return valorTotal;
	}
	
	public void limparCarrinho() {
		carrinhoReservas.clear();
	}
}
