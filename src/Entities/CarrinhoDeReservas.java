package Entities;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class CarrinhoDeReservas {
	
	private List<Reserva> carrinhoReservas = new ArrayList<Reserva>();
	
	Scanner sc = new Scanner (System.in);

	public void listarReservas() {
		for (int i = 0; i < carrinhoReservas.size(); i++) {
			System.out.printf("[%d] " + carrinhoReservas.get(i), i + 1 );
			carrinhoReservas.get(i).MostrarPrecoCalculado();
			if (carrinhoReservas.get(i).getTransporte() == MeioDeTransporte.AVIAO) {
				System.out.printf("Valor da viagem (R$%.2f Taxa de embarque): R$%.2f%n%n", 440.0, carrinhoReservas.get(i).getPrecoCalculado());
			} else if (carrinhoReservas.get(i).getTransporte() == MeioDeTransporte.CARRO) {
				System.out.printf("Valor da viagem (R$%.2f Tarifa do motorista): R$%.2f%n%n", 50.0, carrinhoReservas.get(i).getPrecoCalculado());
			} else {
				System.out.printf("Valor da viagem (%d%% de desconto): R$%.2f%n%n", 30, carrinhoReservas.get(i).getPrecoCalculado());
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
				System.out.println("Carrinho de reservas ATUALIZADO! \n");
			} else {
				System.out.println("Número da reserva inválido!");
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
