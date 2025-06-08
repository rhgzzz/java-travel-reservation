package Entities;

public enum MeioDeTransporte {
	AVIAO("Avião"),
	ONIBUS("Ônibus"),
	CARRO("Carro");
	
	private final String nome;

	private MeioDeTransporte(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	
}
