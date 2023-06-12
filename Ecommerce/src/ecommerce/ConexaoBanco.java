package ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBanco {
	
	
	public  Connection conectaBD(){
		Connection conn= null;
		
		try {
			String url = "jdbc:mysql;//localhost/E-commerce?user=postgres&password=lucas100";
			conn = DriverManager.getConnection(url);
			
		}catch(SQLException erro) {
			System.out.println("Erro ao conectar ao banco de dados: ");
		}
		return conn;
	}
}
