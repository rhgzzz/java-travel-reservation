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
	
	public void adicionarCarrinhoReserva(CarrinhoDeReservas carrinho) {
		this.carrinhoDeReservas = carrinho;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public CarrinhoDeReservas getCarrinhoDeReservas() {
		return carrinhoDeReservas;
	}
	
	
	

}
