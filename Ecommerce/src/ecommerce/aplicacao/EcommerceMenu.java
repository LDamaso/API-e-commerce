package ecommerce.aplicacao;
import java.util.Scanner;

import ecommerce.Produto;
import ecommerce.Carrinhocompras;

import ecommerce.produto.dao.ProdutoDAO;

public class EcommerceMenu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcao;
		Produto produto = new Produto(0,null,0,0);
		ProdutoDAO produtoDao = new ProdutoDAO();
		Carrinhocompras carrinhocompras =  new Carrinhocompras();
		
		do {
			exibirMenu();
			opcao = scanner.nextInt();
			
			switch(opcao){
			case 1:
				System.out.println("Opçao 1-Ver lista de produtos selecionada.");
				
				for(Produto p: ProdutoDAO.getProdutos()) {
					System.out.println("Id do produto: "+p.getIdproduto()+" Nome Produto:" + p.getNome()+" Preco: "+ p.getPreco()+" Quantidade no estoque:"+p.getQtdestoque());
				}
                break;
			case 2:
				System.out.println("Opçao 2-Adcionar Produto selecionada.");
			
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
				System.out.println("Opçao 3 Remover Produto selecionada.");
				
				
				
				System.out.println("Digite o id pro produto a ser Deletado");
				int idproddeletar;
				idproddeletar = scanner.nextInt();
				produto.setIdproduto(idproddeletar);
				
				
				produtoDao.remover(idproddeletar);
				
				
                break;
			case 4:
				System.out.println("Opçao 4 Atualizar detalhes do produto selecionada.");		
				
				System.out.println("Digite o novo nome:");
				String novonome;
				novonome = scanner.next();
				produto.setNome(novonome);
				
				
				System.out.println("Digite o novo preco:");
				Double novopreco;
				novopreco = scanner.nextDouble();
				produto.setPreco(novopreco);
				
				System.out.println("Digite a nova quantidade em estoque: ");
				int novoqtd;
				novoqtd = scanner.nextInt();
				produto.setQtdestoque(novoqtd);
				
				System.out.println("Id do produto para ser atualizado");
				int idprod;
				idprod = scanner.nextInt();
				produto.setIdproduto(idprod);
				
				
				produtoDao.atualizar(produto);
				
				
				
                break;
			case 5:
				System.out.println("Opçao 5 Adcionar Produto ao carrinho selecionada.");
				
				System.out.println("Digite o Id do produto que deseja adcionar no carrinho:");
				int id;
				id = scanner.nextInt();
				
				System.out.println("Digite a quantidade que deseja adcionar ao carrinho:");
				int qtdcarrinho;
				qtdcarrinho = scanner.nextInt();
				
				carrinhocompras.adcionarItem(id, qtdcarrinho);
				
                break;
			case 6:
				System.out.println("Opçao 6 Listar produtos presentes no carrinho selecionada.");
				
				carrinhocompras.listarItens();
				
                break;
			case 7:
				System.out.println("Opçao 7 Remover produto do carrinho selecionada.");
				System.out.println("Digite o nome do produto que deseja remover:");
				String nomeremover =scanner.next();
				
				carrinhocompras.removerDoCarrinho(nomeremover);
				
				break;
			case 8:
				System.out.println("Opçao 8 Confirmar Pedido selecionada.");
				carrinhocompras.confirmar();
				
				System.out.println("Digite 1 para confirmar a compra");
				System.out.println("Digite 2 para cancelar");
				
				if(scanner.nextInt() == 1) {
					System.out.println("Compra confirmada com sucesso");
					carrinhocompras.atualizarEstoque();
					
					
				}else {
					System.out.println("Confimacao cancelada");
				}
					
				break;
			case 0:
				System.out.println("Opçao 0 Saindo do programa....");
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
		System.out.println("6- Listar produtos presentes no carrinho");
		System.out.println("7- Remover produto do carrinho");
		System.out.println("8- Confirmar Pedido");
		System.out.println("0- Saindo do programa...");
		System.out.println("===================");
		
	}
}
