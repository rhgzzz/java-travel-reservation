package Entities;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeReservas {
	
	private List<Reserva> carrinhoReservas = new ArrayList<Reserva>();
	
	public void adicionarReserva(Reserva reserva) {
		carrinhoReservas.add(reserva);
	}
	
	public void removerReserva(Reserva reserva) {
		carrinhoReservas.remove(reserva);
	}
	
	public void listarReservas() {
		for (Reserva reserva : carrinhoReservas) {
			System.out.println(reserva);
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
