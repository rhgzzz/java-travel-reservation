package Entities;

public class Cliente {
	private String nome;
	private CarrinhoDeReservas carrinhoDeReservas;
	
	public Cliente() {
	}

	public Cliente(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public CarrinhoDeReservas getCarrinhoDeReservas() {
		return carrinhoDeReservas;
	}
	
	
	

}
