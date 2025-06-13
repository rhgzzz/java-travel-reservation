package Utils;

import Exceptions.NomeInvalidoException;

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

	    return nomeFormatado.toString().trim(); // Remove espaço extra no final
	}
	
}
