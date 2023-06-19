package ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ecommerce.conectaBanco.ConexaoBanco;


public class Carrinhocompras {
	private List<Item> itemcarrinho;
	
	
	public Carrinhocompras() {
		this.itemcarrinho = new ArrayList<>();
	}
	
	public List<Item> getItems(){
		return itemcarrinho;
	}
	
	
	public void adcionarItem(int idproduto, int quantidadecompra) {
		String sql = "Select * FROM produto WHERE idproduto=?";
		Connection conn= null;
		PreparedStatement pstm= null;
		try {
			conn= ConexaoBanco.conectaBD();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,idproduto);
			
			ResultSet resultSet = pstm.executeQuery();
			if(resultSet.next()) {
				int idprod = resultSet.getInt("idproduto");
				String nome = resultSet.getString("nomeproduto");
				double preco = resultSet.getDouble("preco");
				int qtd = resultSet.getInt("qtdproduto");
				
				Produto p1 = new Produto (idprod,nome,preco,qtd);
				Item item = new Item(p1 , quantidadecompra);
				itemcarrinho.add(item);
			}
			resultSet.close();
			pstm.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!= null) {
					pstm.close();
				}
				if(conn!= null) {
					conn.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		 	 
	}
	public void removerDoCarrinho(String nome) {
		itemcarrinho.removeIf(item -> item.getProduto().getNome().equals(nome));
	}
	
	
	
	public void listarItens(){
		for (Item item: itemcarrinho ) {
			System.out.println("Nome: "+item.getProduto().getNome()+" "+ "Preco: " + item.getProduto().getPreco()+" " + 
					"Quantidade no Carrinho:" + item.getQuantidadecompra());
		}
	}
	

	public double totalCompra() {
		double total = 0.0;
		
		for(Item item : itemcarrinho) {
			
			int quantidadecompra = item.getQuantidadecompra();
			total += item.getProduto().getPreco() * quantidadecompra;
		}
		
		
		return total;
	}

	public List<Item> getItemcarrinho() {
		return itemcarrinho;
	}
	
	
	
	public void confirmar() {
		
		System.out.println("=== Confirmacao Venda ===");
		System.out.println("Items no carrinho:");
		listarItens();
		System.out.println("Preco Total: " + totalCompra());
		}

	public void atualizarEstoque() {
		Connection conn= null;
		PreparedStatement pstm= null;
		try {
			
			
			for(Item item: itemcarrinho) {
				String sql = "update produto set qtdproduto = ? " + "Where idproduto =?";
				conn= ConexaoBanco.conectaBD();
				
				
				int novaqtd;
				pstm = conn.prepareStatement(sql);
				novaqtd = (item.getProduto().getQtdestoque() - item.getQuantidadecompra()) ;
				
				pstm.setInt(1,novaqtd);
				pstm.setInt(2,item.getProduto().getIdproduto());
				
				pstm.execute();
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!= null) {
					pstm.close();
				}
				if(conn!= null) {
					conn.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		itemcarrinho.clear();
	}
	
	
	
}
