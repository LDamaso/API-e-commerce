package ecommerce.produto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import ecommerce.Produto;
import ecommerce.conectaBanco.ConexaoBanco;

public class ProdutoDAO {
	
	
	public void salvar(Produto produto) {
		
		String sql= "Insert into produto(nomeproduto,preco,qtdproduto) Values(?,?,?)";
		
		Connection conn= null;
		PreparedStatement pstm= null;
		try {
			conn= ConexaoBanco.conectaBD();
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,produto.getNome());
			pstm.setDouble(2,produto.getPreco());
			pstm.setInt(3,produto.getQtdestoque());
			
			pstm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
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

	public void atualizar(Produto produto) {
		String sql= "update produto set nomeproduto = ?, preco = ?, qtdproduto = ? "+"Where idproduto =?";
		
		
		Connection conn= null;
		PreparedStatement pstm= null;
		try {
			conn= ConexaoBanco.conectaBD();
			pstm= conn.prepareStatement(sql);
			
			
			pstm.setString(1, produto.getNome() );
			pstm.setDouble(2, produto.getPreco());
			pstm.setInt(3, produto.getQtdestoque());
			
			pstm.setInt(4, produto.getIdproduto());
			
			pstm.execute();
		}catch (Exception e) {
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

	public static List<Produto> getProdutos(){
		
		String sql="Select * FROM produto ";
		
		List<Produto> produtos = new ArrayList<Produto>();

		Connection conn= null;
		PreparedStatement pstm= null;
		
		ResultSet rst = null;
		
		try {
			conn= ConexaoBanco.conectaBD();
			pstm= conn.prepareStatement(sql);
			
			rst = pstm.executeQuery();
			
			
			while(rst.next()) {
				
				Produto produto= new Produto(0,null,0,0);
				
				produto.setIdproduto(rst.getInt("idproduto"));
				produto.setNome(rst.getString("nomeproduto"));
				produto.setPreco(rst.getDouble("preco"));
				produto.setQtdestoque(rst.getInt("qtdproduto"));
			
				produtos.add(produto);
				
			
			
			}	
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(rst != null) {
				rst.close();
			}
			if(pstm!= null) {
				pstm.close();
			}
			if(conn != null) {
				conn.close();
			}
			}catch(final Exception e) {
				e.printStackTrace();
			}
			return produtos;
		}
	}

	
	public void remover(int idproduto) {
		String sql= "Delete from produto where idproduto = ?";
		
		Connection conn= null;
		PreparedStatement pstm = null;
		
		try {
			conn= ConexaoBanco.conectaBD();
			pstm= conn.prepareStatement(sql);
			
			pstm.setInt(1, idproduto);
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!= null) {
					pstm.close();
				}
				if(conn !=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
