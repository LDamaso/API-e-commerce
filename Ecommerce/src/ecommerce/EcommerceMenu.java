package ecommerce;
import java.util.Scanner;


public class EcommerceMenu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcao;
		
		do {
			exibirMenu();
			opcao = scanner.nextInt();
			
			switch(opcao){
			case 1:
				System.out.println("Opçao 1 selecionada.");
                break;
			case 2:
				System.out.println("Opçao 2 selecionada.");
                break;
			case 3:
				System.out.println("Opçao 3 selecionada.");
                break;
			case 4:
				System.out.println("Opçao 4 selecionada.");
                break;
			case 5:
				System.out.println("Opçao 5 selecionada.");
                break;
			case 6:
				System.out.println("Opçao 6 selecionada.");
                break;
			case 0:
				System.out.println("Opçao 0 selecionada.");
			default:
				System.out.println("Opçao invalida");			
			}
			
		} while(opcao !=0);
		
		scanner.close();
		
	}

	
	public static void exibirMenu() {
		
		System.out.println("===== Menu =====");
		System.out.println("1- Ver lista de produtos");
		System.out.println("2- Adcionar produto novo");
		System.out.println("3- Remover Produto");
		System.out.println("4- Atualizar detalhes do produto");
		System.out.println("5- Adcionar Produto ao carrinho");
		System.out.println("6- Confirmar Pedido");
		System.out.println("0- Saindo do programa...");
		
	}
}
