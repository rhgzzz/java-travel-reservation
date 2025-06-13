package Application;

import ServicesMenu.MenuService;

public class Program {

	public static void main(String[] args) {
		
		MenuService menuService = new MenuService();
		menuService.cadastroReserva();
		menuService.mostrarMenuPrincipal();
		
	}
}
