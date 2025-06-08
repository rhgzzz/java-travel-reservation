package Entities;

import java.time.LocalDate;

public class Reserva {
	private String destino;
	private LocalDate data;
	private MeioDeTransporte transporte;
	
	public Reserva() {
	}

	public Reserva(String destino, LocalDate data, MeioDeTransporte transporte) {
		super();
		this.destino = destino;
		this.data = data;
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

	public MeioDeTransporte getTransporte() {
		return transporte;
	}

	public void setTransporte(MeioDeTransporte transporte) {
		this.transporte = transporte;
	}

	@Override
	public String toString() {
		return "Reserva [destino=" + destino + ", data=" + data + ", transporte=" + transporte + "]";
	}
	
	
	
	

}
