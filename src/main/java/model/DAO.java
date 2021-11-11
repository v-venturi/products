package model;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.jasper.tagplugins.jstl.core.Out;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/db_estoque?useTimezone=true&Timezone=UTC";
	private String user = "root";
	private String password = "root";
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
		System.out.println(e);
		return null;			
		}	
	}
	
	public void testarConexao() {
	  try {Connection con = conectar();
	 System.out.println("sucesso!  " + con);
	 con.close();
	} catch (Exception e) {
		System.out.println("erro de conexão  " + e);
	}
		
	}

}
