package ServicesMenu;

import java.io.OptionalDataException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

import Entities.CarrinhoDeReservas;
import Entities.Cliente;
import Entities.MeioDeTransporte;
import Entities.Reserva;
import Exceptions.DataInvalidaException;
import Exceptions.DestinoInvalidoException;
import Exceptions.NomeInvalidoException;
import Exceptions.NumeroReservaInvalidoException;
import Exceptions.OpcaoMenuInvalidaException;
import Exceptions.OpcaoPagamentoInvalidaException;
import Exceptions.TransporteInvalidoException;
import ServicesMetodoPagamento.MetodoPagamento;
import ServicesMetodoPagamento.PagamentoCartaoCredito;
import ServicesMetodoPagamento.PagamentoPix;
import Utils.Validator;

public class MenuService {

	Scanner sc = new Scanner(System.in);
	Cliente cliente = new Cliente();
	Reserva reserva = new Reserva();
	CarrinhoDeReservas carrinhoDeReservas = new CarrinhoDeReservas();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy").withResolverStyle(ResolverStyle.STRICT);
	
	public MenuService() {
	}

	
	
	public void cadastroNome() {	
		
		// Cadastrando meu nome
		while (true) {
			try {
				System.out.print("Digite o seu nome: ");
				String nome = sc.nextLine();
				
				// Validei o nome
				Validator.validarNome(nome);
				
				// Formatei o nome
				nome = Validator.capitalizarNome(nome);
				
				cliente.setNome(nome);
				break;
			} catch (NomeInvalidoException e) {
				System.out.println(e.getMessage());
			}
		} 
	}	
		// Cadastrado a quantidade de reservas que posso fazer por vez!
	public void cadastroReserva () {
		
		String numeroReservasString;
		int numeroReservaInt;
		while (true) {
			try {
				System.out.printf("%s, digite quantas reservas você deseja adicionar ao carrinho: ", cliente.getNome());
				numeroReservasString = sc.nextLine().trim();
				
				
				Validator.validarQuantidadeReserva(numeroReservasString);
				numeroReservaInt = Integer.parseInt(numeroReservasString);
				
				break;
			}catch (NumeroReservaInvalidoException e) {
				System.out.println(e.getMessage());
				
			}catch (NumberFormatException e) {
				System.out.println("⚠ Erro!");
			}
			
		}
		
		System.out.println();
		
		// Cadastrando os dados da reserva
		
		for (int i = 0; i < numeroReservaInt; i++) {
			System.out.printf("Dados da reserva [%d]: %n", i + 1);
			String destino;
			while (true) {
				try {
					System.out.print("Digite o destino de sua viagem: ");
					destino = sc.nextLine();
					
					Validator.validarDestino(destino);
					destino = Validator.capitalizarNome(destino);
					
					break;
				} catch(DestinoInvalidoException e) {
					System.out.println(e.getMessage());
				}
			}
			
			LocalDate data;
			while (true) {
				try {
					System.out.print("Digite a data da viagem (dd/MM/yyyy): ");
					String dataString = sc.nextLine().trim();
					Validator.validarData(dataString);
					
					data = Validator.validarData(dataString);
					break;
				}catch(DataInvalidaException e) {
					System.out.println(e.getMessage());
				}
			}
			
			MeioDeTransporte transporte;
			while (true) {
				try {
					System.out.print("Qual o meio de transporte (AVIÃO, ÔNIBUS, CARRO): ");
					String transporteString = Validator.validarTransporte(sc.nextLine().trim().toUpperCase()) ;
					
					transporte = MeioDeTransporte.valueOf(transporteString);
					break;
				}catch (TransporteInvalidoException e) {
					System.out.println(e.getMessage());
				}
			}
			
			double precoBaseAleatorio = 50.0 + Math.random() * (1000 - 50.0);
			precoBaseAleatorio = Math.round(precoBaseAleatorio * 100.0) / 100.0;
			
			reserva = new Reserva(destino, data, precoBaseAleatorio, transporte);
			
			reserva.MostrarPrecoCalculado();
			carrinhoDeReservas.adicionarReserva(reserva);
			cliente.adicionarCarrinhoReserva(carrinhoDeReservas);
			
			
		}
	}
	
	
	public void mostrarMenuPrincipal() {
		
			
			int opcao = -1;
			
			while (true) {
				System.out.println("\n========== MENU DE RESERVAS ==========");
				System.out.println("1 - Ver carrinho de reservas");
				System.out.println("2 - Adicionar nova reserva");
				System.out.println("3 - Remover reserva do carrinho");
				System.out.println("4 - Finalizar compra");
				System.out.print("Escolha uma opção: ");

				
				try {
					String opcaoString = sc.nextLine();
					opcao = Validator.validarOpcaoMenu(opcaoString, cliente);
					break;
					
				}catch (OpcaoMenuInvalidaException e) {
					System.out.println(e.getMessage());
					
				}
			}
				
			
			System.out.println();
			
			switch (opcao) {
			case 1:
				cliente.getCarrinhoDeReservas().listarReservas();
				mostrarMenuPrincipal();
				break;
				
			case 2:
				cadastroReserva();
				System.out.print("Carrinho de reservas ATUALIZADO! \n");
				mostrarMenuPrincipal();
				break;
				
			case 3:
				System.out.print("Digite o número da reserva que você deseja remover: ");
				carrinhoDeReservas.removerReserva(sc.nextInt());
				sc.nextLine();
				mostrarMenuPrincipal();
				break;
			case 4:
				int opcaoPagamento;
				while (true) {
					System.out.println("1 - Cartão de crédito (10% de taxa)");
					System.out.println("2 - Pix (5% de desconto)");
					System.out.print("Escolha uma opção: ");
					try {
						opcaoPagamento = Validator.ValidarOpcaoPagamento(sc.nextLine());
						break;
					}catch (OpcaoPagamentoInvalidaException e) {
						System.out.println(e.getMessage());
						continue;
					}
				}
				
				
				System.out.println();
				
				
				MetodoPagamento metodoPagamento;
				switch(opcaoPagamento) {
				case 1: 
					metodoPagamento = new PagamentoCartaoCredito();
					metodoPagamento.pagar(carrinhoDeReservas.calcularTotal());
					break;
				case 2: 
					metodoPagamento = new PagamentoPix();
					metodoPagamento.pagar(carrinhoDeReservas.calcularTotal());
					break;
				}
				
				System.out.println();
				
				break;
				
			default:
				System.out.println("⚠️ Opção inválida. Tente novamente.");
			}
			
			
		


	}
}

