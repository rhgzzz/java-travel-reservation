package Entities;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeReservas {
	
	private List<Reserva> carrinhoReservas = new ArrayList<Reserva>();
	
	public void listarReservas() {
		for (int i = 0; i < carrinhoReservas.size(); i++) {
			System.out.printf("[%d] " + carrinhoReservas.get(i) + "%n", i + 1 );
			carrinhoReservas.get(i).MostrarPrecoCalculado();
		}
	}
	
	public void adicionarReserva(Reserva reserva) {
		carrinhoReservas.add(reserva);
	}
	
	public void removerReserva(int index) {
		int indexAjustado = index - 1;
			if (indexAjustado >= 0 && indexAjustado < carrinhoReservas.size()) {
				carrinhoReservas.remove(indexAjustado);
				System.out.printf("Reserva [%d] removida com sucesso!%n", index);
				System.out.println("Carrinho de reservas ATUALIZADO! \n");
				listarReservas();
			} else {
				System.out.println("Número da reserva inválido!");
			}
		
	}
	
	public double calcularTotal() {
		double valorTotal = 0.0;
		for (Reserva reserva : carrinhoReservas) {
			valorTotal += reserva.getPrecoCalculado();
		}
		return valorTotal;
	}
	
	public void limparCarrinho() {
		carrinhoReservas.clear();
	}
}
