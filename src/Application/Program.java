package Application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import Entities.MeioDeTransporte;
import Entities.Reserva;
import Services.TransporteAviao;
import Services.TransporteCarro;
import Services.TransporteOnibus;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Reserva reserva = new Reserva();
		
		System.out.print("Digite o destino de sua viagem: ");
		String destino = sc.nextLine();
		System.out.print("Para quando é sua viagem ? (dd/MM/yyyy) ");
		LocalDate data = LocalDate.parse(sc.nextLine(), dtf);
		System.out.print("Qual o meio de transporte (AVIÃO, ÔNIBUS, CARRO): ");
		String transporteString = sc.nextLine().trim().toUpperCase();
		MeioDeTransporte transporte = MeioDeTransporte.valueOf(transporteString);
		
		double precoBaseAleatorio = 50.0 + Math.random() * (1000 - 50.0);
		precoBaseAleatorio = Math.round(precoBaseAleatorio * 100.0) / 100.0;
		
		reserva = new Reserva(destino, data, precoBaseAleatorio, transporte);
		
		System.out.println(reserva);
		
		Services.MeioDeTransporte meioDeTransporte;
		
		if (reserva.getTransporte() == MeioDeTransporte.AVIAO) {
			meioDeTransporte = new TransporteAviao();
			meioDeTransporte.calcularValorFinal(reserva.getPrecoBase());
		}else if (reserva.getTransporte() == MeioDeTransporte.CARRO) {
			meioDeTransporte = new TransporteCarro();
			meioDeTransporte.calcularValorFinal(reserva.getPrecoBase());
		} else {
			meioDeTransporte = new TransporteOnibus();
			meioDeTransporte.calcularValorFinal(reserva.getPrecoBase());
		}
	}

}
