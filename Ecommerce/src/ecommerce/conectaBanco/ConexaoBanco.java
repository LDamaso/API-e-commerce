package ecommerce.conectaBanco;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConexaoBanco {
	
	private static final String usuario="root";
	private static final String senha="lucas100";
	private static final String bancourl="jdbc:mysql://localhost/E-commerce";
	
	public static Connection conectaBD() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn= null;
		
			conn = DriverManager.getConnection(bancourl,usuario,senha);
			
		return conn;
	}
	public static void main(String[] args) throws Exception {
		Connection con= conectaBD();
		
		if(con!=null) {
			System.out.println("Conexao feita com sucesso");
			con.close();
		}
	}

}
