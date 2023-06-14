package ecommerce.conectaBanco;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConexaoBanco {
	
	private static final String usuario="root";
	private static final String senha="lucas100";
	private static final String bancourl="jdbc:mysql://localhost:3306/ecommerce";
	
	public static Connection conectaBD() throws Exception{
		
		
		Connection connection= DriverManager.getConnection(bancourl, usuario, senha);
		
			
			
		return connection;
	}
	public static void main(String[] args) throws Exception {
		Connection con= conectaBD();
		
		if(con!=null) {
			System.out.println("Conexao feita com sucesso");
			con.close();
		}
	}

}
