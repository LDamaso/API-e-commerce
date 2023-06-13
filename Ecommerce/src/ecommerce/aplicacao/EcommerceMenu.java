package ecommerce.aplicacao;
import java.util.Scanner;

import ecommerce.Produto;
import ecommerce.produto.dao.*;

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
				System.out.println("Opçao 2-Adcionar Produto selecionada.");

				Produto produto = new Produto();
				ProdutoDAO produtoDao = new ProdutoDAO();
				
				System.out.println("Digite o nome do Produto:");
				String nome;
				nome = scanner.next();	
				produto.setNome(nome);
				
				System.out.println("Digite o Preco do Produto:");
				double preco;
				preco= scanner.nextDouble();
				produto.setPreco(preco);
				
				System.out.println("Digite a quantidade em estoque:");
				int qtdestoque;
				qtdestoque = scanner.nextInt();
				produto.setQtdestoque(qtdestoque);
				
				produtoDao.salvar(produto);
				
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
		System.out.println("2- Adcionar produto ");
		System.out.println("3- Remover Produto");
		System.out.println("4- Atualizar detalhes do produto");
		System.out.println("5- Adcionar Produto ao carrinho");
		System.out.println("6- Confirmar Pedido");
		System.out.println("0- Saindo do programa...");
		
	}
}
