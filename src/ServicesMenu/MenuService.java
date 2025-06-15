package ServicesMenu;

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

	
	
	public void cadastroReserva() {	
		
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
		
		// Cadastrado a quantidade de reservas que posso fazer por vez!
		
		String numeroReservasString;
		int numeroReservaInt;
		while (true) {
			try {
				System.out.printf("%s, digite quantas reservas você irá realizar: ", cliente.getNome());
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
					
					break;
				} catch(DestinoInvalidoException e) {
					System.out.println(e.getMessage());
				}
			}
			
			
			
			
			
			
			
			
			
			
			
			
			String[] testes = {
				    // 1. Datas inválidas (inexistentes no calendário)
				    "31/02/2026",    // Fevereiro não tem 31 dias
				    "29/02/2025",    // 2025 não é bissexto
				    "31/04/2025",    // Abril tem apenas 30 dias
				    "00/05/2025",    // Dia zero
				    "15/00/2025",    // Mês zero
				    "32/01/2025",    // Dia 32 inválido
				    "15/13/2025",    // Mês 13 inválido
				    
				    // 2. Datas anteriores à atual (hoje=15/06/2025)
				    "14/06/2025",    // 1 dia antes
				    "01/01/2024",    // Ano anterior
				    
				    // 3. Formatos inválidos
				    "15-05-2025",    // Traços invés de barras
				    "15052025",      // Sem separadores
				    "15/05/25",      // Ano com 2 dígitos
				    "15/MAIO/2025",  // Mês não numérico
				    "  ",            // String vazia
				    "abc",           // Texto não numérico
				    
				    // 4. Datas válidas (devem ser aceitas)
				    "15/06/2025",    // Hoje
				    "16/06/2025",    // Amanhã
				    "29/02/2024",    // Ano bissexto
				    "31/05/2025",    // Mês com 31 dias
				    "01/01/2026"     // Ano novo
				};
			
			LocalDate data;
			
			for (String teste : testes) {
			    try {
			        System.out.println("\nTestando: " + teste);
			        data = Validator.validarData(teste);
			        System.out.println("✅ Data válida: " + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			    } catch (DataInvalidaException e) {
			        System.out.println("❌ Erro: " + e.getMessage());
			    }
			}
			
			System.out.print("Qual o meio de transporte (AVIÃO, ÔNIBUS, CARRO): ");
			String transporteString = sc.nextLine().trim().toUpperCase();
			MeioDeTransporte transporte = MeioDeTransporte.valueOf(transporteString);
			
			double precoBaseAleatorio = 50.0 + Math.random() * (1000 - 50.0);
			precoBaseAleatorio = Math.round(precoBaseAleatorio * 100.0) / 100.0;
			
			
			
			reserva.MostrarPrecoCalculado();
			carrinhoDeReservas.adicionarReserva(reserva);
			cliente.adicionarCarrinhoReserva(carrinhoDeReservas);
			
			System.out.println();
			
		}
	}
	
	public void mostrarMenuPrincipal() {
		
		int opcao;
		
            System.out.println("\n========== MENU DE RESERVAS ==========");
            System.out.println("1 - Ver carrinho de reservas");
            System.out.println("2 - Adicionar nova reserva");
            System.out.println("3 - Remover reserva do carrinho");
            System.out.println("4 - Finalizar compra");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            System.out.println();
            
            switch (opcao) {
                case 1:
                    cliente.getCarrinhoDeReservas().listarReservas();
                    mostrarMenuPrincipal();
                    break;
                    
                case 2:
                	System.out.println("Dados da reserva:");
        			System.out.print("Digite o destino de sua viagem: ");
        			String destino = sc.nextLine();
        			
        			System.out.print("Digite a data da viagem (dd/MM/yyyy): ");
        			LocalDate data = LocalDate.parse(sc.nextLine(), dtf);
        			
        			System.out.print("Qual o meio de transporte (AVIÃO, ÔNIBUS, CARRO): ");
        			String transporteString = sc.nextLine().trim().toUpperCase();
        			MeioDeTransporte transporte = MeioDeTransporte.valueOf(transporteString);
        			
        			double precoBaseAleatorio = 50.0 + Math.random() * (1000 - 50.0);
        			precoBaseAleatorio = Math.round(precoBaseAleatorio * 100.0) / 100.0;
        			
                    cliente.getCarrinhoDeReservas().adicionarReserva(reserva = new Reserva(destino, data, precoBaseAleatorio, transporte));
                    System.out.println();
                    System.out.println("Carrinho de reservas ATUALIZADO! \n");
                    mostrarMenuPrincipal();
                    break;
                    
                case 3:
                	System.out.print("Digite o número da reserva que você deseja remover: ");
                    carrinhoDeReservas.removerReserva(sc.nextInt());
                    System.out.println();
                    mostrarMenuPrincipal();
                    break;
                case 4:
                	System.out.println("1 - Cartão de crédito (10% de taxa)");
                    System.out.println("2 - Pix (5% de desconto)");
                    System.out.print("Escolha uma opção: ");
                    int opcaoPagamento = sc.nextInt();
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
                case 0:
                    System.out.println("✅ Encerrando o sistema. Até logo!");
                    break;
                    
                default:
                    System.out.println("⚠️ Opção inválida. Tente novamente.");
            }
            System.out.println();

        
	}
}
