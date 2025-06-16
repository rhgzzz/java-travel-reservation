package Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ServicesMeioDeTransporte.TransporteAviao;
import ServicesMeioDeTransporte.TransporteCarro;
import ServicesMeioDeTransporte.TransporteOnibus;

public class Reserva {
	private String destino;
	private LocalDate data;
	private double precoBase;
	private double precoCalculado;
	private MeioDeTransporte transporte;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reserva() {
	}

	public Reserva(String destino, LocalDate data, double precoBase, MeioDeTransporte transporte) {
		super();
		this.destino = destino;
		this.data = data;
		this.precoBase = precoBase;
		this.transporte = transporte;
	}
	
	public void MostrarPrecoCalculado() {
		ServicesMeioDeTransporte.MeioDeTransporte meioDeTransporte;
		
		if (transporte == MeioDeTransporte.AVIAO) {
			meioDeTransporte = new TransporteAviao();
		}
		else if (transporte == MeioDeTransporte.CARRO) {
			meioDeTransporte = new TransporteCarro();
		} 
		else {
			meioDeTransporte = new TransporteOnibus();
		}
		
		meioDeTransporte.calcularValorFinal(this);
		System.out.println();
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
				 "Data: " + data.format(dtf) + " | " +
				"Preço Base: R$" + precoBase + " | " +
				 "Meio de Transporte: " + transporte.getNome() + ")";
	}

	
	
	
	
	

}
