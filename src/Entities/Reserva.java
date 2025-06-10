package Entities;

import java.time.LocalDate;

public class Reserva {
	private String destino;
	private LocalDate data;
	private double precoBase;
	private double precoCalculado;
	private MeioDeTransporte transporte;
	
	public Reserva() {
	}

	public Reserva(String destino, LocalDate data, double precoBase, MeioDeTransporte transporte) {
		super();
		this.destino = destino;
		this.data = data;
		this.precoBase = precoBase;
		this.transporte = transporte;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public double getPrecoBase() {
		return precoBase;
	}

	public void setPrecoBase(double precoBase) {
		this.precoBase = precoBase;
	}

	public MeioDeTransporte getTransporte() {
		return transporte;
	}

	public void setTransporte(MeioDeTransporte transporte) {
		this.transporte = transporte;
	}
	
	public double getPrecoCalculado() {
		return precoCalculado;
	}
	

	public void setPrecoCalculado(double precoCalculado) {
		this.precoCalculado = precoCalculado;
	}

	@Override
	public String toString() {
		return "Reserva: (" +
				"Destino: " + destino + " | " +
				 "Data: " + data + " | " +
				"Preço Base: " + precoBase + " | " +
				 "Meio de Transporte: " + transporte + ")";
	}

	
	
	
	
	

}
