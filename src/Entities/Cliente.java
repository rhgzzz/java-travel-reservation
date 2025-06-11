package Entities;

public class Cliente {
	private String nome;
	private CarrinhoDeReservas carrinhoDeReservas;
	
	public Cliente() {
	}

	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public Cliente(CarrinhoDeReservas carrinhoDeReservas) {
		super();
		this.carrinhoDeReservas = carrinhoDeReservas;
	}

	public String getNome() {
		return nome;
	}

	public CarrinhoDeReservas getCarrinhoDeReservas() {
		return carrinhoDeReservas;
	}
	
	
	

}
