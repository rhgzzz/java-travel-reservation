package Utils;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import Exceptions.DataInvalidaException;
import Exceptions.DestinoInvalidoException;
import Exceptions.NomeInvalidoException;
import Exceptions.NumeroReservaInvalidoException;

public class Validator {	
	
	
	
	public static void validarNome(String nome) throws NomeInvalidoException{
		
		if (nome.isBlank()) {
			throw new NomeInvalidoException("\n ⚠ Nome não pode estar vazio! \n");
		}
		
		if (!nome.matches("^[\\p{L}\\s]+$")) {
			throw new NomeInvalidoException("\n ⚠ Nome não pode conter números nem símbolos! \n");
		}
		
		if(nome.length() > 80 ) {
			throw new NomeInvalidoException("\n ⚠ Nome não pode conter mais de 80 caractéres! \n");
		}
		
		if(nome.length() < 3) {
			throw new NomeInvalidoException("\n ⚠ Nome não pode conter menos de 3 caractéres! \n");
		}
	}
	
	public static String capitalizarNome(String nome) {
		// Dividi o nome por espaços
	    String[] partes = nome.trim().toLowerCase().split("\\s+");
	    StringBuilder nomeFormatado = new StringBuilder();

	    for (String parte : partes) {
	        if (parte.length() > 0) {
	        	
	            // Coloquei a primeira letra maiúscula e o restante minúscula
	            nomeFormatado.append(Character.toUpperCase(parte.charAt(0)))
	                         .append(parte.substring(1))
	                         .append(" ");
	        }
	    }

	    return nomeFormatado.toString().trim(); // Removi o espaço extra no final
	}
	
	public static void validarQuantidadeReserva(String quantidadeReservas) throws NumeroReservaInvalidoException {
	
		if (quantidadeReservas.isBlank()) {
			throw new NumeroReservaInvalidoException("\n ⚠ A quantidade de reservas escolhidas para cadastrar não pode ser vazia! \n");
		}
		
		if (!quantidadeReservas.matches("^\\d+$")) {;
			throw new NumeroReservaInvalidoException("\n ⚠ A quantidade de reservas escolhidas para cadastrar não pode conter letras nem símbolos! \n");
		}
		
		
		// Quantidade de reservas a serem cadastradas por vez: MIN/MAX
		
		int quantidadeReservasInt = Integer.parseInt(quantidadeReservas); 
		
		if (quantidadeReservasInt > 5 || quantidadeReservasInt <= 0) {
			throw new NumeroReservaInvalidoException("\n ⚠ A quantidade de reservas escolhidas para cadastrar deve ser entre 1 à 5 por vez! \n");
		}
		
	}
	
	public static void validarDestino(String destino) throws DestinoInvalidoException{
		
		if (destino.isBlank()) {
			throw new DestinoInvalidoException("\n ⚠ Destino não pode estar vazio! \n");
		}
		
		if (!destino.matches("^[\\p{L}\\s]+$")) {
			throw new DestinoInvalidoException("\n ⚠ Destino não pode conter números nem símbolos! \n");
		}
		
		if(destino.length() > 80 ) {
			throw new DestinoInvalidoException("\n ⚠ Destino não pode conter mais de 80 caractéres! \n");
		}
		
		if(destino.length() < 1) {
			throw new DestinoInvalidoException("\n ⚠ Destino não pode conter menos de 1 caractér! \n");
		}
	}
	
	
	public static LocalDate validarData(String data) throws DataInvalidaException {
		
	    if (data == null || data.isBlank()) {
	        throw new DataInvalidaException("\n ⚠ A data definida não pode ser vazia! \n");
	    }

	    if (!data.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
	        throw new DataInvalidaException("\n ⚠ Formato inválido! Use dd/MM/yyyy \n");
	    }

	    try {
	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu")
	            .withResolverStyle(ResolverStyle.STRICT);
	        
	        LocalDate dataConvertida = LocalDate.parse(data, dtf);
	        LocalDate hoje = LocalDate.now();

	        if (dataConvertida.isBefore(hoje)) {
	            throw new DataInvalidaException("\n ⚠ A data definida não pode ser anterior a data atual! | " + hoje.format(DateTimeFormatter.ofPattern("(dd/MM/yyyy) \n")));
	        }

	        return dataConvertida;
	    } catch (DateTimeParseException e) {
	        throw new DataInvalidaException("Data inexistente! Verifique se o dia/mês/ano são válidos.");
	    }
	}
		

        
	}
		

