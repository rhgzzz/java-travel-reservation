package Application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import Entities.CarrinhoDeReservas;
import Entities.Cliente;
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
		
		Cliente cliente = new Cliente();
		Reserva reserva = new Reserva();
		CarrinhoDeReservas carrinhoDeReservas = new CarrinhoDeReservas();
		
		System.out.print("Digite o seu nome: ");
		String nome = sc.nextLine();
		cliente = new Cliente(nome);
		
		
		System.out.printf("%s, digite quantas reservas você irá realizar: ", nome);
		int totalReservas = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < totalReservas; i++) {
			
			System.out.printf("Dados da reserva [%d]: %n", i + 1);
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
			
			System.out.println();
			System.out.printf("[%d] " + reserva, i + 1);
			System.out.println();
			
			
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
			System.out.println();
		}
		
		carrinhoDeReservas.listarReservas();
		
		
		
		
		
	}

}
